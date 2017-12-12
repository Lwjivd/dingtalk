package com.zhenergy.zmp.common.web.editor;

import java.beans.PropertyEditorSupport;

import com.zhenergy.zmp.common.utils.DateHelper;

/**
 * 
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
