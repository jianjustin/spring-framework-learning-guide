package org.janine.jian.security;

import org.janine.jian.domain.Authority;
import org.janine.jian.domain.User;
import org.janine.jian.repository.BaseRepository;
import org.janine.jian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {
    @Autowired
    public BaseRepository baseRepository;
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByMemberUserName(s);
        if (null == user || user.id == null)
            throw new UsernameNotFoundException("用户账户【"+s+"】查询失败");
        List<SimpleGrantedAuthority> list = getGrantedAuthorities(user.id);

        return new org.springframework.security.core.userdetails.User(user.memberUserName,user.memberPassword,list);
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities(long id){
        String sql = "select * from authority a where a.PK_ID IN (" +
                        "select MEMBER_AUTHORITY_ID from role_authority where role_authority.MEMBER_ROLE_ID IN (" +
                            "select MEMBER_ROLE_ID from user_role where MEMBER_USER_ID = ? " +
                        ")" +
                    ") ";
        List<Object> paramValueList = new ArrayList<>();
        paramValueList.add(id);
        List<Authority> list = baseRepository.queryAllBySQL(sql,paramValueList, Authority.class);
        return list.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.memberResourceRouter))
                .collect(Collectors.toList());
    }
}
