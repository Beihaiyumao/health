webpackJsonp([4], {
    FoOc: function (e, n) {
    }, NHnr: function (e, n, t) {
        "use strict";
        Object.defineProperty(n, "__esModule", {value: !0});
        var r = t("+VlJ"), o = {
            render: function () {
                var e = this.$createElement, n = this._self._c || e;
                return n("div", {attrs: {id: "app"}}, [n("router-view")], 1)
            }, staticRenderFns: []
        };
        var a = t("C7Lr")({name: "App"}, o, !1, function (e) {
            t("FoOc")
        }, null, null).exports, i = t("KGCO");
        r.a.use(i.a);
        var p = {
            head: function () {
                return t.e(1).then(t.bind(null, "B6rT"))
            }, login: function () {
                return t.e(2).then(t.bind(null, "QrVH"))
            }, regist: function () {
                return t.e(0).then(t.bind(null, "/FZs"))
            }
        }, u = new i.a({
            routes: [{path: "/", redirect: "/index"}, {
                path: "/index",
                name: "head",
                component: p.head
            }, {path: "/login", name: "login", component: p.login}, {
                path: "/register",
                name: "regist",
                component: p.regist
            }]
        }), c = t("mtWM"), l = t.n(c);
        r.a.config.productionTip = !1, r.a.prototype.$ajax = l.a, new r.a({
            el: "#app",
            router: u,
            components: {App: a},
            template: "<App/>"
        })
    }
}, ["NHnr"]);
//# sourceMappingURL=app.56b024edc371ab0f3de3.js.map