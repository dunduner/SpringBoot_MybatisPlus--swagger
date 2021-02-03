package com.cun.plus;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ning11.zhang
 * @Description:
 * @date 2021/2/2
 * mybatis-plus代码生成器
 */
public class MpG {
    //获取 项目绝对路径
    private static String canonicalPath = "";

    public static void main(String[] args) {
        //获取项目路径
        try {
            canonicalPath = new File("").getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("canonicalPath=" + canonicalPath);
//        String filePath = canonicalPath+"\\mybatisPlusGer\\src\\main\\";
        String filePath = canonicalPath + "/src/main/";
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //111111. 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Zhang.ning");
        gc.setOutputDir(filePath + "java");//代码生成路径
        gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setOpen(true);//生成后打开文件夹
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");


        //2222222. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
//                System.out.println("转换类型：" + fieldType);
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                //默认会把日期类型 转为LocalDateTime ，在查询的时候会报错，这里改为Date
//                String t = fieldType.toLowerCase();
//                if (t.contains("date") || t.contains("time") || t.contains("year")) {
//                    return DbColumnType.DATE;
//                } else {
//                    return super.processTypeConvert(gc, fieldType);
//                }
//
//            }
//        });
        //数据库连接配置
        dsc.setDriverName("com.mysql.jdbc.Driver");
//      dsc.setDriverName("com.mysql.cj.jdbc.Driver"); //mysql8.0使用
        dsc.setUsername("zhangning");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://49.235.166.226:3521/plus?useSSL=false&verifyServerCertificate=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");


        //333333. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true); // 全局大写命名 ORACLE 注意
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//采用驼峰映射
        strategy.setEntityLombokModel(true);//【实体】是否为lombok模型（默认 false）
        strategy.setLogicDeleteFieldName("deleted");
        //.setTablePrefix("tb_")// 此处可以修改为您的表前缀
        // ********设置要映射的表名 ********设置要映射的表名 ********设置要映射的表名 ********设置要映射的表名
        strategy.setInclude(new String[]{"student"}); // 需要生成的表.如果需要生成所有的, 注释掉此行就可以
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表

        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);


        //44444. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.cun.plus");// 自定义包路径
        pkConfig.setController("controller");// 这里是控制器包名，默认 web
        pkConfig.setMapper("mapper");//设置Mapper包名，默认mapper
        pkConfig.setService("service");// 设置Service包名，默认service
        pkConfig.setEntity("entity");// 设置Entity包名，默认entity,继承的父类  已序列化
        pkConfig.setXml("mapper");//设置Mapper XML包名，默认mapper/xml


        // 55555.注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                //设置一些自定义的参数
                Map<String, Object> map = new HashMap<String, Object>();
                String abcValue = this.getConfig().getGlobalConfig().getAuthor() + "-mp";
                map.put("abc", abcValue);
                this.setMap(map);
            }
        };
        // 调整 xml 生成目录演示---现在会生产在com.cun.plus.mapper下
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return filePath + "resources/mapper/xml/" + tableInfo.getEntityName() + "Mapper.xml";
//            }
//        });
//        cfg.setFileOutConfigList(focList);

        //666666. 整合配置
        mpg.setGlobalConfig(gc)
                .setDataSource(dsc)
                .setStrategy(strategy)
                .setPackageInfo(pkConfig)
                .setCfg(cfg);
        //777777. 执行
        mpg.execute();
        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}
