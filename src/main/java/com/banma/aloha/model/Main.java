/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.banma.aloha.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-07-24 16:50
 **/
public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession= sessionFactory.openSession();
        UserFactMapper userFactMapper=sqlSession.getMapper(UserFactMapper.class);
        UserFact userFact=userFactMapper.selectByPrimaryKey(1);
        System.out.println(userFact);
    }
}
