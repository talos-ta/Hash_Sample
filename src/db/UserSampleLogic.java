package db;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import entity.UserSample;
import mapper.UserSampleMapper;

@RequestScoped
public class UserSampleLogic {

	@Inject
	SqlSessionManager sqlSessionManager;

	/**
	 * idによるユーザー特定
	 * @param id
	 * @return
	 */
	public UserSample getUserById(String id) {
		UserSample user = null;
		try (SqlSession session = sqlSessionManager.getSqlSessionFactory().openSession()) {
			UserSampleMapper mapper = session.getMapper(UserSampleMapper.class);
			user = mapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ユーザーを登録する
	 * @param user
	 * @return
	 */
	public int insertUser(UserSample user) {
		int result = 0;
		try (SqlSession session = sqlSessionManager.getSqlSessionFactory().openSession()) {
			UserSampleMapper mapper = session.getMapper(UserSampleMapper.class);
			result = mapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
