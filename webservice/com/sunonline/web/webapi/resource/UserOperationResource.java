package com.sunonline.web.webapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.internal.jpa.parsing.UnaryMinus;

import com.sunonline.web.bean.User;
import com.sunonline.web.dao.UserDao;
import com.sunonline.web.dao.UserDaoImpl;
import com.sunonline.web.utils.UserUtils;

/**
 * 用户资源操作实现类
 * @author snowalker
 * 16.7.6
 */
@Path(value = "")
public class UserOperationResource implements IUserOperationResource {

	
	//声明用户DAO
	UserDao userdao = new UserDaoImpl();
	
	//用户注册
	@POST
	@Path("user/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public String userRegister(@QueryParam("pwd")String pwd, @QueryParam("usermobile")String usermobile, @QueryParam("useremail")String useremail) {
		
		//生成随机用户名
		String usernickname = UserUtils.generateRandomUsername();
		/*接收外接输入的注册信息
		访问Dao层写入数据库*/
		String flag = userdao.UserRegister(usernickname, pwd, usermobile, useremail);
		if ("successfully creating user".equals(flag)) {
			return "successfully creating user";
		}
		return "failed creating user";
	}

	//用户登录，通过邮箱/手机号
	//参数中的inputString不确定，做判断之后再根据具体是什么数据进行判断
	@POST
	@Path("user/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public User userLoginVerifyByMobileOrEmail(@QueryParam("inputString")String inputString, @QueryParam("userpwd")String userpwd) {
		/*根据输入字符串的类型判断是何种
		inputString是邮箱*/
		if (inputString != null && inputString.contains("@") && inputString.contains("."))  {
			return userdao.verifyUserEmail(inputString, userpwd);
		} else if (inputString != null) {
			//inputString是手机号
			return userdao.verifyUserMobile(inputString, userpwd);
		} 
		//其他情况不进行验证直接返回失败
		return null;
	}
	
	@Override
	public String userModifyUsername() {
		return null;
	}

}
