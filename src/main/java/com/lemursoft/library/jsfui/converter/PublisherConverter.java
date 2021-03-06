package com.lemursoft.library.jsfui.converter;

import com.google.common.base.Strings;
import com.lemursoft.library.dao.PublisherDao;
import com.lemursoft.library.domain.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

// для преобразования выбранного значения из выпадающего списка в конкретный объект Publisher
@FacesConverter(forClass = Publisher.class)
@Component
public class PublisherConverter implements Converter {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (Strings.isNullOrEmpty(value)) {

            return null;
        }
        return publisherDao.get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return ((Publisher)value).getId().toString();

    }
}
