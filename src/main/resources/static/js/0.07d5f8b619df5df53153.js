webpackJsonp([0], {
    "/FZs": function (t, s, e) {
        "use strict";
        Object.defineProperty(s, "__esModule", {value: !0});
        var i = e("X/3H"), a = e.n(i);
        for (var r in i) "default" !== r && function (t) {
            e.d(s, t, function () {
                return i[t]
            })
        }(r);
        var l = e("s1oh");
        var c = function (t) {
            e("SIty")
        }, n = e("C7Lr")(a.a, l.a, !1, c, null, null);
        s.default = n.exports
    }, SIty: function (t, s) {
    }, "X/3H": function (t, s) {
    }, s1oh: function (t, s, e) {
        "use strict";
        var i = {
            render: function () {
                var t = this, s = t.$createElement, e = t._self._c || s;
                return e("div", [e("div", {staticClass: "dowebok"}, [e("div", {staticClass: "logo"}), t._v(" "), t._m(0), t._v(" "), t._m(1), t._v(" "), t._m(2), t._v(" "), t._m(3), t._v(" "), t._m(4), t._v(" "), t._m(5), t._v(" "), e("div", {staticClass: "reg-bar"}, [e("router-link", {
                    staticClass: "reg",
                    attrs: {to: {name: "login"}}
                }, [t._v("登录")]), t._v(" "), e("a", {
                    staticClass: "forget",
                    attrs: {href: "javascript:"}
                }, [t._v("忘记密码")])], 1)]), t._v(" "), e("div", {
                    staticClass: "alert alert-warning",
                    attrs: {id: "myAlert2"}
                }, [e("a", {
                    staticClass: "close",
                    attrs: {href: "#", "data-dismiss": "alert"}
                }, [t._v("×")]), t._v(" "), e("p", {staticStyle: {"text-align": "center"}}, [t._v(t._s(t.msg))])])])
            }, staticRenderFns: [function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form-item-regist"}, [s("input", {
                    attrs: {
                        id: "username",
                        type: "text",
                        autocomplete: "off",
                        placeholder: "用户名"
                    }
                }), this._v(" "), s("p", {staticClass: "tipUsername"}, [this._v("用户名错误")])])
            }, function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form-item-regist"}, [s("input", {
                    attrs: {
                        id: "password",
                        type: "password",
                        autocomplete: "off",
                        placeholder: "登录密码"
                    }
                }), this._v(" "), s("p", {staticClass: "tip"}, [this._v("密码不正确")])])
            }, function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form-item-regist"}, [s("input", {
                    attrs: {
                        id: "tpassword",
                        type: "password",
                        autocomplete: "off",
                        placeholder: "确认登录密码"
                    }
                }), this._v(" "), s("p", {staticClass: "tip0"}, [this._v("确认密码不为空")]), this._v(" "), s("p", {staticClass: "tip1"}, [this._v("密码不一致，请重新输入")])])
            }, function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form-item-regist"}, [s("input", {
                    attrs: {
                        id: "email",
                        type: "text",
                        autocomplete: "off",
                        placeholder: "邮箱"
                    }
                }), this._v(" "), s("p", {staticClass: "tipEmail"}, [this._v("请输入合法的邮箱地址")])])
            }, function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form"}, [s("input", {
                    attrs: {
                        id: "identifying",
                        type: "text",
                        autocomplete: "off",
                        placeholder: "验证码"
                    }
                }), this._v(" "), s("p", {staticClass: "tipIde"}, [this._v("验证码格式错误")]), this._v(" "), s("p", {staticClass: "tipIdeisfalse"}, [this._v("验证码错误,请重试")]), this._v(" "), s("img", {
                    attrs: {
                        src: "http://localhost:8080/_HealthControl/user/getImgVerify",
                        onclick: "changeCheckcode(this)",
                        height: "45",
                        width: "100"
                    }
                })])
            }, function () {
                var t = this.$createElement, s = this._self._c || t;
                return s("div", {staticClass: "form-item-regist"}, [s("button", {attrs: {id: "submit"}}, [this._v("注 册")])])
            }]
        };
        s.a = i
    }
});
//# sourceMappingURL=0.07d5f8b619df5df53153.js.map