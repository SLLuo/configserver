<template>
  <el-container>
    <el-header style="padding: 0;">
      <el-menu default-active="/" class="el-menu-demo" mode="horizontal" @select="handleSelect"
               background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <template v-for="(menu1, index1) in menus">
          <el-menu-item :index="menu1.path" v-if="!hasChildren(menu1)">
            <i :class="'el-icon-' + menu1.icon"></i>
            <span slot="title">{{menu1.name}}</span>
          </el-menu-item>
          <el-submenu :index="submenuIndex(index1)" v-if="hasChildren(menu1)">
            <template slot="title">
              <i :class="'el-icon-' + menu1.icon"></i>
              <span>{{menu1.name}}</span>
            </template>
            <template v-for="(menu2, index2) in menu1.children">
              <el-menu-item :index="menu2.path" v-if="!hasChildren(menu2)">
                <i :class="'el-icon-' + menu2.icon"></i>
                <span slot="title">{{menu2.name}}</span>
              </el-menu-item>
              <el-submenu :index="submenuIndex(index1, index2)" v-if="hasChildren(menu2)">
                <template slot="title">
                  <i :class="'el-icon-' + menu2.icon"></i>
                  <span>{{menu2.name}}</span>
                </template>
                <template v-for="menu3 in menu2.children">
                  <el-menu-item :index="menu3.path">
                    <i :class="'el-icon-' + menu3.icon"></i>
                    <span slot="title">{{menu3.name}}</span>
                  </el-menu-item>
                </template>
              </el-submenu>
            </template>
          </el-submenu>
        </template>
      </el-menu>
    </el-header>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: 'App',
    data: function () {
      return {
        menus: [
          {
            icon: 'setting',
            name: 'name1',
            path: '/'
          },
          {
            icon: 'setting',
            name: 'name2',
            children: [
              {
                icon: 'setting',
                name: 'name21',
                path: '/users'
              },
              {
                icon: 'setting',
                name: 'name22',
                path: '/helloworld/name22'
              }
            ]
          },
          {
            icon: 'setting',
            name: 'name3',
            children: [
              {
                icon: 'setting',
                name: 'name31',
                path: '/helloworld/name31'
              },
              {
                icon: 'setting',
                name: 'name32',
                children: [
                  {
                    icon: 'setting',
                    name: 'name321',
                    path: '/helloworld/name321'
                  },
                  {
                    icon: 'setting',
                    name: 'name322',
                    path: '/helloworld/name322'
                  }
                ]
              }
            ]
          }
        ],
        transitionName: 'slide-left'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        this.$router.push(key);
      },
      hasChildren(menu) {
        return menu.children && menu.children.length > 0;
      },
      submenuIndex: function (indexs) {
        var len = arguments.length
        var num = 0;
        for (var i = 0; i < len; i++) {
          num *= 100;
          num += arguments[i];
        }
        return 'submenu_' + num;
      }
    }
  }
</script>

<style>
  html, body {
    margin: 0;
  }
</style>
