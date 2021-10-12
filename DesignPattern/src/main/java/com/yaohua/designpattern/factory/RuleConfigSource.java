package com.yaohua.designpattern.factory;


/**
 * 场景：根据配置文件的后缀（json&xml&yaml&properties），选择不同的解析器
 * （JsonRuleConfigConfigParser、XmlRuleConfigParse..），
 * 将储存在文件中的配置文件解析成内存对象RuleConfig。
 */
public class RuleConfigSource {

    public RuleConfigSource(){
    }

    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if("json".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new JsonRuleConfigParser();
        }else if("xml".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new XmlRuleConfigParse();
        }else if("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParse();
        }else if("properties".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new PropertiesRuleConfigParse();
        }else{
            throw new InvalidRuleConfigException("Rule config file format is not supported:"+ruleConfigFilePath);
        }
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return null;
    }
}
