package com.sunonline.web.webapi.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
			return "注册成功，用户已创建";
		}
		return "您使用的手机号或邮箱已经被他人占用，请更换之后重新注册";
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
	
	/*
	 * 用户修改昵称
	 * 接收新的用户昵称
	 * 替换原有的昵称
	 * 无条件直接修改
	 * @param 接收参数  用户手机号
	 */
	@POST
	@Path("user/changer/nickname")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public String userModifyUserNickName(@QueryParam("mobile")String userMobile, @QueryParam("nickname")String newNickName) {
		
		return userdao.modifyUserNickName(userMobile, newNickName);
	}


	/*
	 * 用户修改密码
	 * 用户初始状态为登录
	 * 只需要提供用户的信息及要更改的密码即可
	 */
	@POST
	@Path("user/changer/userpwd/logged")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String userModifyUserPasswdDirectly(@QueryParam("userpwd")String userpwd, @QueryParam("mobile")String userMobile) {
		
		return userdao.userModifyUserPasswdDirectly(userpwd, userMobile);
	}
	/*
	 * 用户修改密码
	 * 用户初始状态为未登录
	 * 需要首先验证要验证用户合法性
	 * step:A
	 */
	@POST
	@Path("user/changer/userpwd/notlogged")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String userVerifyValidityBeforeModifyUserpwd(@QueryParam("mobile") String userMobile) {
		
		return userdao.userVerifyValidityBeforeModifyUserpwd(userMobile);
	}
	/*
	 * 如果验证 成功
	 * 则进入该阶段
	 * step:B
	 * 使用该手机号更改密码
	 */
	@POST
	@Path("user/changer/userpwd/notlogged/validater")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String userModifyUserPasswdValidated(@QueryParam("userpwd")String userpwd, @QueryParam("mobile")String userMobile) {
		
		return userdao.userModifyUserPasswdDirectly(userpwd, userMobile);
	}

}
