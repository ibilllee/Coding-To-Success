(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-47ce0a1d"],{"1da1":function(t,r,e){"use strict";e.d(r,"a",(function(){return o}));e("d3b7");function n(t,r,e,n,o,i,a){try{var s=t[i](a),c=s.value}catch(u){return void e(u)}s.done?r(c):Promise.resolve(c).then(n,o)}function o(t){return function(){var r=this,e=arguments;return new Promise((function(o,i){var a=t.apply(r,e);function s(t){n(a,o,i,s,c,"next",t)}function c(t){n(a,o,i,s,c,"throw",t)}s(void 0)}))}}},2673:function(t,r,e){t.exports=e.p+"img/symbol.1f224c81.png"},"498a":function(t,r,e){"use strict";var n=e("23e7"),o=e("58a8").trim,i=e("c8d2");n({target:"String",proto:!0,forced:i("trim")},{trim:function(){return o(this)}})},"4ceb":function(t,r,e){"use strict";e.r(r);var n=function(){var t=this,r=t.$createElement,n=t._self._c||r;return n("div",{attrs:{id:"login-regist-page"}},[n("div",{staticClass:"login-regist-container "},[n("div",{staticClass:"tab-bar"},[n("div",{class:t.ifActive(0),on:{click:function(r){return t.indexChange(0)}}},[t._v(" 用户登录 ")]),n("span",[t._v("|")]),n("div",{class:t.ifActive(1),on:{click:function(r){return t.indexChange(1)}}},[t._v(" 用户注册 ")])]),n("div",{staticClass:"symbol"},[n("img",{attrs:{src:e("2673"),id:"logo",alt:""}})]),n("div",{staticClass:"main-container"},[0==t.currentIndex?n("div",{staticClass:"login-container"},[n("el-form",{ref:"loginForm",attrs:{model:t.loginForm,rules:t.loginRules}},[n("el-form-item",{attrs:{prop:"userId"}},[n("el-input",{attrs:{placeholder:"请输入用户账号"},model:{value:t.loginForm.userId,callback:function(r){t.$set(t.loginForm,"userId",r)},expression:"loginForm.userId"}})],1),n("el-form-item",{attrs:{prop:"password"}},[n("el-input",{attrs:{placeholder:"请输入用户密码","show-password":""},model:{value:t.loginForm.password,callback:function(r){t.$set(t.loginForm,"password",r)},expression:"loginForm.password"}})],1),n("el-form-item",[n("el-button",{staticClass:"login-button",on:{click:function(r){return t.login("loginForm")}}},[t._v("立即登录")])],1)],1)],1):t._e(),1==t.currentIndex?n("div",{staticClass:"regist-container"},[n("el-form",{ref:"registForm",attrs:{model:t.registForm,rules:t.registRules}},[n("el-form-item",{attrs:{prop:"userId"}},[n("el-input",{attrs:{placeholder:"请输入用户账号"},model:{value:t.registForm.userId,callback:function(r){t.$set(t.registForm,"userId",r)},expression:"registForm.userId"}})],1),n("el-form-item",{attrs:{prop:"password"}},[n("el-input",{attrs:{placeholder:"请输入用户密码","show-password":""},model:{value:t.registForm.password,callback:function(r){t.$set(t.registForm,"password",r)},expression:"registForm.password"}})],1),n("el-form-item",{attrs:{prop:"confirm"}},[n("el-input",{attrs:{placeholder:"请确认用户密码","show-password":""},model:{value:t.registForm.confirm,callback:function(r){t.$set(t.registForm,"confirm",r)},expression:"registForm.confirm"}})],1),n("el-form-item",[n("el-button",{staticClass:"regist-button",on:{click:function(r){return t.regist("registForm")}}},[t._v("立即注册")])],1),n("el-form-item",[n("el-button",{staticClass:"reset-button",on:{click:function(r){return t.resetForm("registForm")}}},[t._v("重置表单")])],1)],1)],1):t._e()])])])},o=[],i=e("1da1"),a=(e("498a"),e("96cf"),e("1bab"));e("4328");function s(t){return Object(a["a"])({url:"/user/register",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/user/login",method:"post",data:t})}var u={created:function(){return Object(i["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:case"end":return t.stop()}}),t)})))()},data:function(){var t=this,r=/^[a-zA-Z0-9_-]{4,16}$/,e=function(t,r,e){console.log("hello");var n=r.trim();""==n?e(new Error("密码不能为空!")):n.length<6?e(new Error("密码不能少于6位字符")):n.length>16?e(new Error("密码不能多于16位字符")):e()},n=function(r,e,n){var o=e.trim();""==o?n(new Error("请再次输入密码")):o!=t.registForm.password?n(new Error("两次输入的密码不一致")):n()},o=function(t,e,n){var o=e.trim();""==o?n(new Error("用户账号不能为空!")):o.length<4?n(new Error("用户账号不能少于6位字符")):o.length>16?n(new Error("用户账号不能多于16位字符")):r.test(o)?n():n(new Error("用户账号不可以包含特殊字符"))};return{currentIndex:0,loginForm:{userId:"",password:""},registForm:{userId:"",password:"",confirm:""},loginRules:{userId:[{validator:o,trigger:"blur"}],password:[{validator:e,trigger:"blur"}]},registRules:{userId:[{validator:o,trigger:"blur"}],password:[{validator:e,trigger:"blur"}],confirm:[{validator:n,trigger:"blur"}]}}},methods:{ifActive:function(t){return this.currentIndex==t?{"tab-item":!0,"tab-item-active":!0}:{"tab-item":!0}},indexChange:function(t){this.currentIndex=t},resetForm:function(t){this.$refs[t].resetFields()},login:function(t){var r=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:n=r.loginForm,r.$refs[t].validate(function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(e){var o,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e){t.next=6;break}return t.next=3,c(n);case 3:o=t.sent,console.log(o),200==o.data.metaInfo.status?(r.$message({message:"恭喜你，登录成功！",type:"success"}),r.currentIndex=0,i=o.data.data,i.avatar="http://8.135.61.132/cts/".concat(i.avatar),i=JSON.stringify(i),console.log("userInfo",i),localStorage.setItem("userInfo",i),r.$router.push("/index")):r.$message({message:"登录失败",type:"warning"});case 6:case"end":return t.stop()}}),t)})));return function(r){return t.apply(this,arguments)}}());case 2:case"end":return e.stop()}}),e)})))()},regist:function(t){var r=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:n=r.registForm,r.$refs[t].validate(function(){var t=Object(i["a"])(regeneratorRuntime.mark((function t(e){var o;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e){t.next=8;break}return t.next=3,s(n);case 3:o=t.sent,console.log(o),201==o.data.metaInfo.status?(r.$message({message:"恭喜你，注册成功！现在将跳转到登录界面！",type:"success"}),r.currentIndex=0):r.$message({message:"注册失败",type:"warning"}),t.next=9;break;case 8:return t.abrupt("return",!1);case 9:case"end":return t.stop()}}),t)})));return function(r){return t.apply(this,arguments)}}());case 2:case"end":return e.stop()}}),e)})))()}},computed:{}},l=u,f=(e("ffe2"),e("2877")),h=Object(f["a"])(l,n,o,!1,null,"9df6eb1c",null);r["default"]=h.exports},5899:function(t,r){t.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(t,r,e){var n=e("1d80"),o=e("5899"),i="["+o+"]",a=RegExp("^"+i+i+"*"),s=RegExp(i+i+"*$"),c=function(t){return function(r){var e=String(n(r));return 1&t&&(e=e.replace(a,"")),2&t&&(e=e.replace(s,"")),e}};t.exports={start:c(1),end:c(2),trim:c(3)}},"5f15":function(t,r,e){},"96cf":function(t,r,e){var n=function(t){"use strict";var r,e=Object.prototype,n=e.hasOwnProperty,o="function"===typeof Symbol?Symbol:{},i=o.iterator||"@@iterator",a=o.asyncIterator||"@@asyncIterator",s=o.toStringTag||"@@toStringTag";function c(t,r,e){return Object.defineProperty(t,r,{value:e,enumerable:!0,configurable:!0,writable:!0}),t[r]}try{c({},"")}catch(C){c=function(t,r,e){return t[r]=e}}function u(t,r,e,n){var o=r&&r.prototype instanceof m?r:m,i=Object.create(o.prototype),a=new j(n||[]);return i._invoke=L(t,e,a),i}function l(t,r,e){try{return{type:"normal",arg:t.call(r,e)}}catch(C){return{type:"throw",arg:C}}}t.wrap=u;var f="suspendedStart",h="suspendedYield",p="executing",d="completed",g={};function m(){}function v(){}function w(){}var y={};y[i]=function(){return this};var b=Object.getPrototypeOf,x=b&&b(b(R([])));x&&x!==e&&n.call(x,i)&&(y=x);var F=w.prototype=m.prototype=Object.create(y);function E(t){["next","throw","return"].forEach((function(r){c(t,r,(function(t){return this._invoke(r,t)}))}))}function k(t,r){function e(o,i,a,s){var c=l(t[o],t,i);if("throw"!==c.type){var u=c.arg,f=u.value;return f&&"object"===typeof f&&n.call(f,"__await")?r.resolve(f.__await).then((function(t){e("next",t,a,s)}),(function(t){e("throw",t,a,s)})):r.resolve(f).then((function(t){u.value=t,a(u)}),(function(t){return e("throw",t,a,s)}))}s(c.arg)}var o;function i(t,n){function i(){return new r((function(r,o){e(t,n,r,o)}))}return o=o?o.then(i,i):i()}this._invoke=i}function L(t,r,e){var n=f;return function(o,i){if(n===p)throw new Error("Generator is already running");if(n===d){if("throw"===o)throw i;return $()}e.method=o,e.arg=i;while(1){var a=e.delegate;if(a){var s=I(a,e);if(s){if(s===g)continue;return s}}if("next"===e.method)e.sent=e._sent=e.arg;else if("throw"===e.method){if(n===f)throw n=d,e.arg;e.dispatchException(e.arg)}else"return"===e.method&&e.abrupt("return",e.arg);n=p;var c=l(t,r,e);if("normal"===c.type){if(n=e.done?d:h,c.arg===g)continue;return{value:c.arg,done:e.done}}"throw"===c.type&&(n=d,e.method="throw",e.arg=c.arg)}}}function I(t,e){var n=t.iterator[e.method];if(n===r){if(e.delegate=null,"throw"===e.method){if(t.iterator["return"]&&(e.method="return",e.arg=r,I(t,e),"throw"===e.method))return g;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return g}var o=l(n,t.iterator,e.arg);if("throw"===o.type)return e.method="throw",e.arg=o.arg,e.delegate=null,g;var i=o.arg;return i?i.done?(e[t.resultName]=i.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=r),e.delegate=null,g):i:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,g)}function _(t){var r={tryLoc:t[0]};1 in t&&(r.catchLoc=t[1]),2 in t&&(r.finallyLoc=t[2],r.afterLoc=t[3]),this.tryEntries.push(r)}function O(t){var r=t.completion||{};r.type="normal",delete r.arg,t.completion=r}function j(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(_,this),this.reset(!0)}function R(t){if(t){var e=t[i];if(e)return e.call(t);if("function"===typeof t.next)return t;if(!isNaN(t.length)){var o=-1,a=function e(){while(++o<t.length)if(n.call(t,o))return e.value=t[o],e.done=!1,e;return e.value=r,e.done=!0,e};return a.next=a}}return{next:$}}function $(){return{value:r,done:!0}}return v.prototype=F.constructor=w,w.constructor=v,v.displayName=c(w,s,"GeneratorFunction"),t.isGeneratorFunction=function(t){var r="function"===typeof t&&t.constructor;return!!r&&(r===v||"GeneratorFunction"===(r.displayName||r.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,w):(t.__proto__=w,c(t,s,"GeneratorFunction")),t.prototype=Object.create(F),t},t.awrap=function(t){return{__await:t}},E(k.prototype),k.prototype[a]=function(){return this},t.AsyncIterator=k,t.async=function(r,e,n,o,i){void 0===i&&(i=Promise);var a=new k(u(r,e,n,o),i);return t.isGeneratorFunction(e)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},E(F),c(F,s,"Generator"),F[i]=function(){return this},F.toString=function(){return"[object Generator]"},t.keys=function(t){var r=[];for(var e in t)r.push(e);return r.reverse(),function e(){while(r.length){var n=r.pop();if(n in t)return e.value=n,e.done=!1,e}return e.done=!0,e}},t.values=R,j.prototype={constructor:j,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=r,this.done=!1,this.delegate=null,this.method="next",this.arg=r,this.tryEntries.forEach(O),!t)for(var e in this)"t"===e.charAt(0)&&n.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=r)},stop:function(){this.done=!0;var t=this.tryEntries[0],r=t.completion;if("throw"===r.type)throw r.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function o(n,o){return s.type="throw",s.arg=t,e.next=n,o&&(e.method="next",e.arg=r),!!o}for(var i=this.tryEntries.length-1;i>=0;--i){var a=this.tryEntries[i],s=a.completion;if("root"===a.tryLoc)return o("end");if(a.tryLoc<=this.prev){var c=n.call(a,"catchLoc"),u=n.call(a,"finallyLoc");if(c&&u){if(this.prev<a.catchLoc)return o(a.catchLoc,!0);if(this.prev<a.finallyLoc)return o(a.finallyLoc)}else if(c){if(this.prev<a.catchLoc)return o(a.catchLoc,!0)}else{if(!u)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return o(a.finallyLoc)}}}},abrupt:function(t,r){for(var e=this.tryEntries.length-1;e>=0;--e){var o=this.tryEntries[e];if(o.tryLoc<=this.prev&&n.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=r&&r<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=r,i?(this.method="next",this.next=i.finallyLoc,g):this.complete(a)},complete:function(t,r){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&r&&(this.next=r),g},finish:function(t){for(var r=this.tryEntries.length-1;r>=0;--r){var e=this.tryEntries[r];if(e.finallyLoc===t)return this.complete(e.completion,e.afterLoc),O(e),g}},catch:function(t){for(var r=this.tryEntries.length-1;r>=0;--r){var e=this.tryEntries[r];if(e.tryLoc===t){var n=e.completion;if("throw"===n.type){var o=n.arg;O(e)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,n){return this.delegate={iterator:R(t),resultName:e,nextLoc:n},"next"===this.method&&(this.arg=r),g}},t}(t.exports);try{regeneratorRuntime=n}catch(o){Function("r","regeneratorRuntime = r")(n)}},c8d2:function(t,r,e){var n=e("d039"),o=e("5899"),i="​᠎";t.exports=function(t){return n((function(){return!!o[t]()||i[t]()!=i||o[t].name!==t}))}},ffe2:function(t,r,e){"use strict";e("5f15")}}]);
//# sourceMappingURL=chunk-47ce0a1d.3956ba93.js.map