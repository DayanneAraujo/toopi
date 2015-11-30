package models;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import java.io.Serializable;

/**
 * Created by amaro on 29/11/15.
 */
@Transactional
public class ModelPersistence implements Serializable {

    private static final long serialVersionUID = -1306814076153121179L;

    public void save() {
        JPA.em().persist(this);
    }

    public void update() {
        JPA.em().merge(this);
    }

    public void delete() {
        JPA.em().remove(this);
    }

}
