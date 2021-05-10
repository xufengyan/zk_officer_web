import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/views/layout/Layout'

/** note: Submenu only appear when children.length>=1
 *  detail see  https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 **/

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    perms: ['GET /aaa','POST /bbb']     will control the page perms (you can set multiple perms)
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
    noCache: true                if true ,the page will no be cached(default is false)
  }
**/
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/authredirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/errorPage/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/errorPage/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      }
    ]
  }
]

export const asyncRoutes = [
  {
    path: '/sys',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'sysManage',
    meta: {
      title: '系统管理',
      icon: 'chart'
    },
    children: [
      {
        path: 'admin',
        component: () => import('@/views/sys/admin'),
        name: 'admin',
        meta: {
          perms: ['GET /admin/admin/list', 'POST /admin/admin/create', 'POST /admin/admin/update', 'POST /admin/admin/delete'],
          title: '管理员',
          noCache: true
        }
      },

      {
        path: 'log',
        component: () => import('@/views/sys/log'),
        name: 'log',
        meta: {
          perms: ['GET /admin/log/list'],
          title: '操作日志',
          noCache: true
        }
      },
      {
        path: 'role',
        component: () => import('@/views/sys/role'),
        name: 'role',
        meta: {
          perms: ['GET /admin/role/list', 'POST /admin/role/create', 'POST /admin/role/update', 'POST /admin/role/delete', 'GET /admin/role/permissions', 'POST /admin/role/permissions'],
          title: '角色管理',
          noCache: true
        }
      },
      {
        path: 'os',
        component: () => import('@/views/sys/os'),
        name: 'os',
        meta: {
          perms: ['GET /admin/storage/list', 'POST /admin/storage/create', 'POST /admin/storage/update', 'POST /admin/storage/delete'],
          title: '对象存储',
          noCache: true
        }
      }
    ]
  },

  {
    path: '/basic',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'basicManage',
    meta: {
      title: '官网管理',
      icon: 'chart'
    },
    children: [
      {
        path: 'list',
        component: () => import('@/views/basic/list'),
        name: 'basicList',
        meta: {
          perms: ['GET /admin/basic/list'],
          title: '网站基本信息',
          noCache: true
        }
      },
      {
        path: 'update',
        component: () => import('@/views/basic/update'),
        name: 'basicUpdate',
        meta: {
          perms: ['GET /admin/basic/update'],
          title: '修改网站基本信息',
          noCache: true
        },
        hidden: true
      },
      {
        path: 'schemeList',
        component: () => import('@/views/scheme/list'),
        name: 'schemeList',
        meta: {
          perms: ['GET /admin/scheme/list'],
          title: '解决方案',
          noCache: true
        }
      },
      {
        path: 'schemeCreate',
        component: () => import('@/views/scheme/create'),
        name: 'schemeCreate',
        meta: {
          perms: ['GET /admin/scheme/create'],
          title: '添加解决方案',
          noCache: true
        },
        hidden: true
      },
      {
        path: 'schemeEdit',
        component: () => import('@/views/scheme/edit'),
        name: 'schemeEdit',
        meta: {
          perms: ['GET /admin/scheme/edit'],
          title: '修改解决方案',
          noCache: true
        },
        hidden: true
      },
      {
        path: 'productList',
        component: () => import('@/views/product/list'),
        name: 'productList',
        meta: {
          perms: ['GET /admin/product/list'],
          title: '展示产品管理',
          noCache: true
        }
      },
      {
        path: 'productCreate',
        component: () => import('@/views/product/create'),
        name: 'productCreate',
        meta: {
          perms: ['GET /admin/product/create'],
          title: '添加产品',
          noCache: true
        },
        hidden: true
      },
      {
        path: 'productEdit',
        component: () => import('@/views/product/edit'),
        name: 'productEdit',
        meta: {
          perms: ['GET /admin/product/edit'],
          title: '修改产品',
          noCache: true
        },
        hidden: true
      },
      {
        path: 'categoryList',
        component: () => import('@/views/category/list'),
        name: 'categoryList',
        meta: {
          perms: ['GET /admin/product/list'],
          title: '产品系列管理',
          noCache: true
        }
      },
      {
        path: 'paragraphList',
        component: () => import('@/views/paragraph/list'),
        name: 'paragraphList',
        meta: {
          perms: ['GET /admin/paragraph/list'],
          title: '技术领域和优势',
          noCache: true
        }
      },
      {
        path: 'dwList',
        component: () => import('@/views/download/list'),
        name: 'dwList',
        meta: {
          perms: ['GET /admin/download/list'],
          title: '说明文件下载管理',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/image',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'imageManage',
    meta: {
      title: '官网图片管理',
      icon: 'chart'
    },
    children: [
      {
        path: 'carousel',
        component: () => import('@/views/imageManagement/carousel'),
        name: 'carousel',
        meta: {
          perms: ['GET /admin/management/list'],
          title: '轮播图片管理',
          noCache: true
        }
      },
      {
        path: 'collaborate',
        component: () => import('@/views/imageManagement/collaborate'),
        name: 'collaborate',
        meta: {
          perms: ['GET /admin/management/list'],
          title: '合作伙伴管理',
          noCache: true
        }
      },
      {
        path: 'employment',
        component: () => import('@/views/imageManagement/employment'),
        name: 'employment',
        meta: {
          perms: ['GET /admin/management/list'],
          title: '招聘管理',
          noCache: true
        }
      },
      {
        path: 'honor',
        component: () => import('@/views/imageManagement/honor'),
        name: 'honor',
        meta: {
          perms: ['GET /admin/management/list'],
          title: '荣誉管理',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    children: [
      {
        path: 'password',
        component: () => import('@/views/profile/password'),
        name: 'password',
        meta: { title: '修改密码', noCache: true }
      },
      {
        path: 'notice',
        component: () => import('@/views/profile/notice'),
        name: 'notice',
        meta: { title: '通知中心', noCache: true }
      }
    ],
    hidden: true
  },

  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
