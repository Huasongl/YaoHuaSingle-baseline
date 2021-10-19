package com.yaohua.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

public class IRuleConfigParserFactory {
    private static final Map<String,IRuleConfigParser> cacheParsers =new HashMap<>();

    static {
        cacheParsers.put("json",new JsonRuleConfigParser());
        cacheParsers.put("xml",new XmlRuleConfigParse());
        cacheParsers.put("yaml",new YamlRuleConfigParse());
        cacheParsers.put("properties",new PropertiesRuleConfigParse());
    }

    public static IRuleConfigParser getInstance(String ruleConfigFileExtension){
        if(ruleConfigFileExtension == null || ruleConfigFileExtension.isEmpty()){
            return null;
        }
        return cacheParsers.get(ruleConfigFileExtension.toLowerCase());
    }
    public static IRuleConfigParser create(String ruleConfigFileExtension){
        IRuleConfigParser parser = null;
        if("json".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new JsonRuleConfigParser();
        }else if("xml".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new XmlRuleConfigParse();
        }else if("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParse();
        }else if("properties".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new PropertiesRuleConfigParse();
        }
        return parser;
    }
}
