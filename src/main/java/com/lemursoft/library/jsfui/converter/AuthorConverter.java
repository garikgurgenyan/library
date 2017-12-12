package com.lemursoft.library.jsfui.converter;

import com.google.common.base.Strings;
import com.lemursoft.library.dao.AuthorDao;
import com.lemursoft.library.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

// для преобразования выбранного значения из выпадающего списка в конкретный объект Author
@FacesConverter(forClass = Author.class)
@Component
public class AuthorConverter implements Converter {

    @Autowired
    private AuthorDao authorDao;



    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return authorDao.get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return ((Author)value).getId().toString();
    }
}
