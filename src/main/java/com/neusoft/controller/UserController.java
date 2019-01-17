package com.neusoft.controller;

import com.alibaba.fastjson.JSONException;
import com.github.pagehelper.Page;
import com.neusoft.DataDictionary.BlackState;
import com.neusoft.dao.UserMapper;
import com.neusoft.entity.HealthyArticle;
import com.neusoft.entity.Question;
import com.neusoft.entity.Result;
import com.neusoft.entity.User;
import com.neusoft.service.HealthyArticleService;
import com.neusoft.service.QuestionService;
import com.neusoft.service.UserService;
import com.neusoft.tool.PageInfo;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HealthyArticleService healthyArticleService;

    /**
     * 用户注册
     *
     * @throws IOException
     * @throws JSONException
     **/
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Result regist(@RequestBody User regist, HttpSession session) throws JSONException {
        User register = userMapper.login(regist.getEmail());
        String idCode = (String) session.getAttribute("sRand");
        System.out.println(idCode+"上边");
        if (register != null && register.getBlackState().equals(BlackState.BLACK_STATE_TRUE.getCode())) {
            String msg = userMapper.selectUserBlackMsg(regist.getEmail());
            return new Result(200, "抱歉您已被管理员拉黑，具体原因:" + msg, false);
        }
        if (register != null) {
            return new Result(200, "该邮箱已存在,请直接登录!", false);
        }
        if (regist.getIdentifying() == null || regist.getIdentifying().isEmpty()) {
            return new Result(200, "请输入验证码", false);
        }
        if (!regist.getIdentifying().equals(idCode)) {

            return new Result(200, "验证码错误", false);
        }
        if (register == null && regist.getIdentifying().equals(idCode)) {
            userService.registNewUser(regist);
            return new Result(100, "注册成功", true);
        }
        return new Result(200, "未知错误", false);
    }

    /**
     * 用户登录
     *
     * @throws IOException
     * @throws JSONException
     ****/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User userLogin, HttpSession session) throws JSONException {
        User userLoginInfo = userMapper.login(userLogin.getEmail());
        if (userLoginInfo != null && userLoginInfo.getBlackState().equals(BlackState.BLACK_STATE_TRUE.getCode())) {
            String msg = userMapper.selectUserBlackMsg(userLogin.getEmail());
            return new Result(200, "抱歉您已被管理员拉黑，具体原因:" + msg, false);
        }
        if (!userService.login(userLogin)) {
            return new Result(200, userService.getErrorMessage(), false);
        } else {
            //根据邮箱获取用用户id
            User userName = userService.selectUserInfoByEmail(userLogin.getEmail());
            String username = userName.getUsername();
            String userId = userName.getUserId();
            session.setAttribute("username", username);
            session.setAttribute("userId", userId);
            return new Result(100, "登陆成功!", true, userName);
        }
    }

    /**
     * 用户退出登录
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(Model model, HttpSession session) {
        model.asMap().remove("username");
        session.invalidate();
        return "../index";
    }

    /**
     * 永久注销账户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public Result deleteUser(@RequestParam("userId") String userId) {

        return userService.deleteUser(userId);
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @GetMapping("/updatePassword")
    public Result updatePassword(@RequestParam("userId") String userId, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        User userInfo = userService.selectUserInfoByUserId(userId);

        if (!userInfo.getPassword().equals(oldPassword)) {
            return new Result(200, "旧密码不正确", false);
        }
        if (userInfo.getPassword().equals(oldPassword)) {
            int code = userService.updatePassword(userId, newPassword);
            if (code == 1) {
                return new Result(100, "修改密码成功", true);
            } else {
                return new Result(200, "修改密码失败", false);
            }
        }
        return new Result(200, "未知错误", false);
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserInfo", method = RequestMethod.GET)
    public Result selectUserInfo(@RequestParam("userId") String userId) {
        User userInfo = userService.selectUserInfoByUserId(userId);

        return new Result(100, "成功", true, userInfo);
    }

    /*该方法主要作用是获得随机生成的颜色*/
    public Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255) {
            s = 91;
        }
        if (e > 255) {
            e = 97;
        }
        int r, g, b;
        r = s + random.nextInt(e - s); //随机生成RGB颜色中的r值
        g = s + random.nextInt(e - s); //随机生成RGB颜色中的g值
        b = s + random.nextInt(e - s); //随机生成RGB颜色中的b值
        return new Color(r, g, b);
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    /**
     * 图片验证码
     */
    @RequestMapping(value = "getImgVerify", method = RequestMethod.GET)
    public void getImgVerify(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        //设置不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        //指定生成的响应图片,一定不能缺少这句话,否则错误.
        response.setContentType("image/jpeg");
        int width = 100, height = 28; //指定生成验证码的宽度和高度
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //创建BufferedImage对象,其作用相当于一图片
        Graphics g = image.getGraphics(); //创建Graphics对象,其作用相当于画笔
        Graphics2D g2d = (Graphics2D) g; //创建Grapchics2D对象
        Random random = new Random();
        Font font = new Font("华文宋体", Font.BOLD, 19); //定义字体样式
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height); //绘制背景
        g.setFont(font); //设置字体
        g.setColor(getRandColor(180, 200));

        //绘制100条颜色和位置全部为随机产生的线条,该线条为2f
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int x1 = random.nextInt(6) + 1;
            int y1 = random.nextInt(12) + 1;
            BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); //定制线条样式
            Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
            g2d.setStroke(bs);
            g2d.draw(line); //绘制直线
        }
        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }
        //输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。
        String sRand = "";
        String ctmp = "";
        int itmp = 0;
        //制定输出的验证码为四位
        for (int i = 0; i < 4; i++) {
            switch (random.nextInt(3)) {
                case 1: //生成A-Z的字母
                    itmp = random.nextInt(26) + 65;
                    ctmp = String.valueOf((char) itmp);
                    break;
                case 2:
                    itmp = random.nextInt(26) + 65;
                    ctmp = String.valueOf((char) itmp);
                    break;
                default:
                    itmp = random.nextInt(10) + 48;
                    ctmp = String.valueOf((char) itmp);
                    break;
            }
            sRand += ctmp;

            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
            g.setColor(color);
            //将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示
            /*将文字旋转制定角度*/
            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate((30) * 3.14 / 266, 19 * i + 8, 7);
            /*缩放文字*/
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1f) {
                scaleSize = 1f;
            }
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            g.drawString(ctmp, 19 * i + 19, 19);
        }
        g.dispose(); //释放g所占用的系统资源
        session.removeAttribute("sRand");
        session.setAttribute("sRand", sRand);//存储到session
        ImageIO.write(image, "JPEG", response.getOutputStream()); //输出图片
        System.out.println(sRand+"下边");
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public int updateUserInfo(@RequestBody User user) {
        int code = userService.updateUserInfo(user);
        return code;
    }

    /**
     * 更新头像
     *
     * @param file
     * @param userId
     * @return
     */
    @GetMapping("/updateHeadPhoto")
    public Result updateHeadPhoto(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) {
        return userService.updateHeadPhoto(file, userId);
    }

    /**
     * 我的问题列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @RequestMapping(value = "/myQuestion", method = RequestMethod.GET)
    public PageInfo<Question> myQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                         @RequestParam("userId") String userId) {
        Page<Question> myQuestion = questionService.selectQuestionByUser(pageNum, pageSize, userId);
        PageInfo<Question> pageInfo = new PageInfo<>(myQuestion);
        return pageInfo;
    }

    /**
     * 搜索我的问题
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param title
     * @return
     */
    @GetMapping("/selectMyQuestion")
    public PageInfo<Question> selectMyQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                               @RequestParam("userId") String userId, @RequestParam("title") String title) {
        Page<Question> selectMyQuestion = userService.selectMyQuestion(pageNum, pageSize, userId, title);
        PageInfo<Question> pageInfo = new PageInfo<>(selectMyQuestion);
        return pageInfo;
    }

    /**
     * 我收藏的文章列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @RequestMapping(value = "myCollectionArticle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectHealthyArticleByUserId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                 @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                 @RequestParam("userId") String userId) {
        Page<HealthyArticle> myCollectionArticle = healthyArticleService.selectHealthyArticleByUserId(pageNum, pageSize, userId);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(myCollectionArticle);
        return pageInfo;
    }

    /**
     * 模糊查询我的收藏
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param title
     * @return
     */
    @GetMapping("/selectMyHealthArticle")
    public PageInfo<HealthyArticle> selectMyHealthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                           @RequestParam("userId") String userId, @RequestParam("title") String title) {
        Page<HealthyArticle> selectMyHealthyArticle = userService.selectMyHealthyArticle(pageNum, pageSize, userId, title);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(selectMyHealthyArticle);
        return pageInfo;
    }
}