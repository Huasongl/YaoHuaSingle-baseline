package com.yaohua.commonmodule;

public abstract class DomainInitializer {

    public String WXSCHEME0;
    public String WXSCHEME1;

    public String QULSCHEME;
    public String OtherQULSCHEME;

    public String DOMAINNAME_ANDROID_READER = null;

    public DomainInitializer() {
        this.init();
    }

    public abstract void init();
}
