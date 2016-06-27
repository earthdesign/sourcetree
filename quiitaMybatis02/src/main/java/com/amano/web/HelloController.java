package com.amano.web;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amano.web.model.MyDataModel;

@Controller
public class HelloController {
    @Autowired
    private MyDataEntityRepository repository;

    private String errormessege;

    /*
     * @RequestMapping(value="/", method=RequestMethod.GET) public String
     * index(Model model) { model.addAttribute("title", "Helo Page");
     * //model.addAttribute("value", ""); model.addAttribute("message",
     * "MyDataEntity List."); List<MyDataEntity> data = repository.findAll();
     * model.addAttribute("data", data); return "helo"; }
     */

    /**
     * 初期表示
     * @param model
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        // リダイレクト先ページにパラメータを引き渡す
        model.addAttribute("title", "CRUD Page");
        model.addAttribute("message", "MyEntity List.");

        /*// 設定ファイルを読み込む
        InputStream in = SpringWebAppApplication.class.getResourceAsStream("/mybatis-config.xml");

        // ★設定ファイルを元に、 SqlSessionFactory を作成する
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();

        // レコード取得
        MyDataModel result = session.selectOne("dao.selectMyEntity", 2);

        // レコード削除
        session.delete("dao.deleteMyEntity", "test7");

        // レコード更新
        MyDataModel updateMyDataModel = new MyDataModel();
        updateMyDataModel.setId(2);
        updateMyDataModel.setName("update8");
        session.update("dao.updateMyEntity", updateMyDataModel);

        // レコード追加
        MyDataModel myDataModel = new MyDataModel();
        myDataModel.setName("test0");
        myDataModel.setMail("test0");
        myDataModel.setTel("test0");
        try {
            session.insert("dao.insertMyEntity", myDataModel);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }*/

        // mapper経由
        /*
         * MyDataEntityMapper mapper =
         * session.getMapper(MyDataEntityMapper.class); MyDataEntity result =
         * mapper.selectMyEntity(3);
         */

        // dao経由
        /*
         * ApplicationContext ctx = new
         * ClassPathXmlApplicationContext("mybatis-config.xml");
         * MybatisSpringMyDataEntityDao mybatisSpringMyDataEntityDao =
         * ctx.getBean(MybatisSpringMyDataEntityDao.class); MyDataEntity
         * myDataEntity = mybatisSpringMyDataEntityDao.findById(1);
         */

        // ★SqlSession を使って SQL を実行する
        // where句
        /*
         * MyDataEntity myDataEntity = new MyDataEntity();
         * myDataEntity.setName("test4"); myDataEntity.setMail("test5");
         * myDataEntity.setTel("test6"); MyDataEntity result =
         * session.selectOne("dao.selectMyEntity" ,myDataEntity);
         */
        // List<Map<String, Object>> result =
        // session.selectList("dao.selectMyEntity");

        // リダイレクト先ページにパラメータを引き渡す
        /*model.addAttribute("data", result);*/

        return "helo";
    }

    /**
     * 要素を追加する.
     * @param item 追加する要素
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String form(@Validated @RequestParam("findvalue") String find, @RequestParam("updatename") String updatename,
            @RequestParam("deletename") String deletename, Model model) {

        // リダイレクト先に値をセットｓ
        model.addAttribute("title", "CRUD Page");
        model.addAttribute("message", "MyEntity List.");
        model.addAttribute("findvalue", find);
        model.addAttribute("updatename", updatename);
        model.addAttribute("deletename", deletename);

        // 設定ファイルを読み込む
        InputStream in = SpringWebAppApplication.class.getResourceAsStream("/mybatis-config.xml");

        // ★設定ファイルを元に、 SqlSessionFactory を作成する
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();

        // 名前でMyDataを検索
        List<MyDataModel> result = (List) session.selectList("dao.selectListMyEntity", find);

        // レコード更新
        MyDataModel updateMyDataModel = new MyDataModel();
        updateMyDataModel.setId(6);
        updateMyDataModel.setName(updatename);
        session.update("dao.updateNameMyEntity", updateMyDataModel);

        // レコード削除
        session.delete("dao.deleteMyEntity", deletename);

        try {
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        model.addAttribute("data", result);

        return "helo";
    }

}
