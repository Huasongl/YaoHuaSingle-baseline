package com.yaohua.designpattern.factory;


/**
 * 场景：根据配置文件的后缀（json&xml&yaml&properties），选择不同的解析器
 * （JsonRuleConfigConfigParser、XmlRuleConfigParse..），
 * 将储存在文件中的配置文件解析成内存对象RuleConfig。
 *
 *
 * summary 工厂方法的本质就是将一个类的的创建逻辑独立出去，用一个工厂类来组装&创建；
 * 也可以说是代理类；
 * 简单工厂方法：
 * 工厂方法：
 * 抽象工厂方法：
 *
 */
public class RuleConfigSource {

    public RuleConfigSource(){
    }

    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
//        parser = getIRuleConfigParser(ruleConfigFilePath, ruleConfigFileExtension);
        parser = IRuleConfigParserFactory.create(ruleConfigFileExtension);
        if(parser ==null){
            throw new InvalidRuleConfigException("Rule config file format is not supported:"+ ruleConfigFilePath);
        }
        String configText = "";
        return parser.parse(configText);
    }

    private IRuleConfigParser getIRuleConfigParser(String ruleConfigFilePath, String ruleConfigFileExtension) throws InvalidRuleConfigException {
        IRuleConfigParser parser;
        if("json".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new JsonRuleConfigParser();
        }else if("xml".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new XmlRuleConfigParse();
        }else if("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParse();
        }else if("properties".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new PropertiesRuleConfigParse();
        }else{
            throw new InvalidRuleConfigException("Rule config file format is not supported:"+ ruleConfigFilePath);
        }
        return parser;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return null;
    }
}
