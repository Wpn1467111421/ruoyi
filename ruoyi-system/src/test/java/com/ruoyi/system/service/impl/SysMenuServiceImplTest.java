package com.ruoyi.system.service.impl;

import com.alibaba.testable.core.annotation.MockInvoke;
import com.alibaba.testable.core.tool.OmniAccessor;
import com.alibaba.testable.core.tool.OmniConstructor;
import com.alibaba.testable.processor.annotation.EnablePrivateAccess;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.mapper.SysMenuMapper;
import org.junit.Test;

import java.lang.Long;
import java.util.*;

import static com.alibaba.testable.core.matcher.InvocationVerifier.verifyInvoked;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@EnablePrivateAccess
public class SysMenuServiceImplTest {

    private SysMenuServiceImpl sysMenuServiceImpl = new SysMenuServiceImpl();

    public static class Mock {
        @MockInvoke(
                targetClass = SysUser.class,
                targetMethod = "isAdmin"
        )
        public static boolean isAdmin(Long userId) {
            return userId != null && 1L == userId;
        }

        @MockInvoke(
                targetClass = SysMenuMapper.class,
                targetMethod = "selectMenuListByUserId"
        )
        public List<SysMenu> selectMenuListByUserId(
                SysMenu menu) {
            List<SysMenu> list = new ArrayList<>();
            SysMenu sysMenu1 = new SysMenu();
            sysMenu1.setMenuName("test1");
            SysMenu sysMenu2 = new SysMenu();
            sysMenu2.setMenuName("test3");
            list.add(sysMenu1);
            list.add(sysMenu2);
            return list;
        }

        @MockInvoke(
                targetClass = SysMenuMapper.class,
                targetMethod = "selectMenuList"
        )
        public List<SysMenu> selectMenuList(
                SysMenu menu) {
            List<SysMenu> list = new ArrayList<>();
            SysMenu sysMenu1 = new SysMenu();
            sysMenu1.setMenuName("test1");
            SysMenu sysMenu2 = new SysMenu();
            sysMenu2.setMenuName("test2");
            list.add(sysMenu1);
            list.add(sysMenu2);
            return list;
        }

        @MockInvoke(
                targetClass = SysMenuMapper.class,
                targetMethod = "selectMenuPermsByUserId"
        )
        public List<String> selectMenuPermsByUserId(Long userId) {
            List<String> strList = new ArrayList<>();
            strList.add("1");
            strList.add("2");
            strList.add("3");
            strList.add("4");
            strList.add("5");
            return strList;
        }
    }

    @Test
    public void should_mock_selectMenuList(){
        List<SysMenu> list1 = sysMenuServiceImpl.selectMenuList(new SysMenu(), 1L);
        assertEquals("test1", list1.get(0).getMenuName());
        List<SysMenu> list2 = sysMenuServiceImpl.selectMenuList(new SysMenu(), 2L);
        assertEquals("test3", list2.get(1).getMenuName());
        verifyInvoked("selectMenuList").withTimes(1);
        verifyInvoked("selectMenuListByUserId").withTimes(1);
    }

    @Test
    public void should_mock_selectMenuPermsByUserId(){
        Set<String> set = sysMenuServiceImpl.selectMenuPermsByUserId(1L);
        assertTrue("1",set.contains("1"));
        verifyInvoked("selectMenuPermsByUserId").withTimes(1);
    }
}
