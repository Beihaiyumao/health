webpackJsonp([2], {
    A4Y4: function (t, a) {
    }, QrVH: function (t, a, s) {
        "use strict";
        Object.defineProperty(a, "__esModule", {value: !0});
        var e = {
            render: function () {
                var t = this, a = t.$createElement, s = t._self._c || a;
                return s("div", [s("div", {
                    staticClass: "dowebok",
                    attrs: {model: t.formData}
                }, [s("div", {staticClass: "logo"}), t._v(" "), s("div", {staticClass: "form-item-login"}, [s("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model",
                        value: t.formData.username,
                        expression: "formData.username"
                    }],
                    attrs: {id: "username", type: "text", autocomplete: "off", placeholder: "邮箱"},
                    domProps: {value: t.formData.username},
                    on: {
                        input: function (a) {
                            a.target.composing || t.$set(t.formData, "username", a.target.value)
                        }
                    }
                }), t._v(" "), s("p", {staticClass: "tipEmail"}, [t._v("请输入合法的邮箱地址")])]), t._v(" "), s("div", {staticClass: "form-item-login"}, [s("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model",
                        value: t.formData.password,
                        expression: "formData.password"
                    }],
                    attrs: {id: "password", type: "password", autocomplete: "off", placeholder: "登录密码"},
                    domProps: {value: t.formData.password},
                    on: {
                        input: function (a) {
                            a.target.composing || t.$set(t.formData, "password", a.target.value)
                        }
                    }
                }), t._v(" "), s("p", {staticClass: "tipPassword"}, [t._v("请输入密码")])]), t._v(" "), s("div", {staticClass: "form-item-login"}, [s("button", {
                    attrs: {id: "submit"},
                    on: {click: t.login}
                }, [t._v("登 录")])]), t._v(" "), s("div", {staticClass: "reg-bar"}, [s("router-link", {
                    staticClass: "reg",
                    attrs: {to: {name: "regist"}}
                }, [t._v("立即注册")]), t._v(" "), s("a", {
                    staticClass: "forget",
                    attrs: {href: ""}
                }, [t._v("忘记密码")])], 1)]), t._v(" "), t._m(0)])
            }, staticRenderFns: [function () {
                var t = this.$createElement, a = this._self._c || t;
                return a("div", {
                    staticClass: "alert alert-warning",
                    attrs: {id: "myAlert2"}
                }, [a("a", {staticClass: "close", attrs: {href: "#", "data-dismiss": "alert"}}, [this._v("×")])])
            }]
        };
        var r = s("C7Lr")({
            data: function () {
                return {formData: {username: "", password: ""}}
            }, methods: {
                login: function () {
                    this.$ajax.post("/user/login", this.formData).then(function (t) {
                    })
                }
            }
        }, e, !1, function (t) {
            s("A4Y4")
        }, null, null);
        a.default = r.exports
    }
});
//# sourceMappingURL=2.9918cd5c9e3b9119bfaf.js.map