package net.suncaper.userprovider.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.models.auth.In;
import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.userprovider.domain.User;
import net.suncaper.userprovider.domain.UserExample;
import net.suncaper.userprovider.mapper.UserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public PagableResponse<List<User>> list(PageRequest request, String keyword) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());

        UserExample ex = new UserExample();
        if (StringUtils.isNoneBlank(keyword)) {
            UserExample.Criteria criteria = ex.createCriteria();
            criteria.andUsernameLike("%" + keyword + "%");

            UserExample.Criteria criteriaSecondary = ex.createCriteria();
            criteriaSecondary.andNickNameLike("%" + keyword + "%");

            ex.or(criteriaSecondary);
        }

        List<User> users = userMapper.selectByExample(ex);
        return new PagableResponse(((Page) users).getTotal(), users);
    }

    public void saveUser(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }

    public Boolean checkUserName(String username, Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        if (id != null) {
            criteria.andIdNotEqualTo(id);
        }

        return userMapper.countByExample(example) == 0;
    }

    public Integer removeUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return 1;
    }

    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User getUserWithRoleAndPermissionByName(String username) {
        List<User> users = userMapper.getUserWithRoleAndPermissionByName(username);

        return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
    }

    public List<User> getContactsDeptId(Integer deptId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andDeptIdEqualTo(deptId);
        criteria.andContactEqualTo(Boolean.TRUE);

        return userMapper.selectByExample(userExample);
    }

    public List<User> getSecretarysDeptId(Integer deptId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andDeptIdEqualTo(deptId);
        criteria.andSecretaryEqualTo(Boolean.TRUE);

        return userMapper.selectByExample(userExample);
    }

    public List<User> getLeaders() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLeaderEqualTo(Boolean.TRUE);

        return userMapper.selectByExample(userExample);
    }
}
