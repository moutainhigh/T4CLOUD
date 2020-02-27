// 自定义判断元素类型JS
export function toType(obj) {
  return {}.toString
      .call(obj)
      .match(/\s([a-zA-Z]+)/)[1]
      .toLowerCase();
}

// 参数过滤函数
export function filterNull(o) {
  for (var key in o) {
    if (o[key] === null || o[key] === "") {
      delete o[key];
    }
    if (toType(o[key]) === "string") {
      o[key] = o[key].trim();
    } else if (toType(o[key]) === "object") {
      o[key] = filterNull(o[key]);
    } else if (toType(o[key]) === "array") {
      o[key] = filterNull(o[key]);
    }
  }
  return o;
}

// 表单对象去重
export function removeSame(form, total) {
  let keys = Object.keys(form)
  keys.forEach(item => {
    if (total[item]) {
      form[item] = total[item]
    }
  })
  return form
}

// 生成首页路由
export function generateIndexRoute(data) {
  let indexRouter = [
    {
      path: "/",
      name: "dashboard",
      component: ()=>import('@/views/FirstPage'),
      meta: { title: "首页" },
      redirect: "/dashboard/analysis",
      children: [...generateChildRouters(data)]
    },
    {
      path: "*",
      redirect: "/404",
      hidden: true
    }
  ];
  return indexRouter;
}

// 生成嵌套路由（子路由）
function  generateChildRouters (data) {
  const routers = [];
  for (var item of data) {
    if(item.hidden==0||item.menuType==2){ // 隐藏路由: 0-隐藏,1-展示 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
      continue
    }
    let component = "";
    if(item.component&&item.component.indexOf("layouts")>=0){
       component = "components/"+item.component;
    }else{
       component = "views/"+item.component;
    }
    // eslint-disable-next-line
    // let URL = (item.meta.url|| '').replace(/{{([^}}]+)?}}/g, (s1, s2) => eval(s2)) // URL支持{{ window.xxx }}占位符变量
    // if (isURL(URL)) {
    //   item.meta.url = URL;
    // }

    let menu =  {
      path: item.url?item.url:'/',
      name: item.name,
      // redirect:item.redirect,
      component: resolve => require(['@/' + component+'.vue'], resolve),
      hidden:item.hidden
      //component:()=> import(`@/views/${item.component}.vue`),
      // meta: {
      //   title:item.meta.title ,
      //   icon: item.meta.icon,
      //   url:item.meta.url ,
      //   permissionList:item.meta.permissionList,
      //   keepAlive:item.meta.keepAlive,
      //   /*update_begin author:wuxianquan date:20190908 for:赋值 */
      //   internalOrExternal:item.meta.internalOrExternal
      //   /*update_end author:wuxianquan date:20190908 for:赋值 */
      // }
    }
    if(item.alwaysShow){
      menu.alwaysShow = true;
      menu.redirect = menu.path;
    }
    if (item.children && item.children.length > 0) {
      const array = [...generateChildRouters(item.children)];
      if(array.length>0){
        menu.children = [...generateChildRouters(item.children)];
      }
    }
    routers.push(menu);
  }
  return routers
}
