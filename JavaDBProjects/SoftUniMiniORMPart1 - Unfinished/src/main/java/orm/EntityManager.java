package orm;

import orm.annotations.Column;
import orm.annotations.Id;
import orm.interfaces.DbContext;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persist(E entity) throws IllegalAccessException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        if (value == null || (int) value <= 0){
            return this.doInsert(entity, primary);
        }
        return this.doUpdate(entity, primary);
    }

    public Iterable find(Class table) {
        return null;
    }

    public Iterable find(Class table, String where) {
        return null;
    }

    public Object findFirst(Class table) {
        return null;
    }

    public Object findFirst(Class table, String where) {
        return null;
    }

    private boolean doInsert(E entity, Field primary) {
        String tableName = this.getTableName(entity.getClass());
        String[] tableFields = this.getTableFields(entity);
        String[] tableValues = this.getTableValues(entity);
        return false;
    }

    private boolean doUpdate(E entity, Field primary) {
        return false;
    }

    public Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
    }

    private String getTableName(Class<?> aClass) {
        return aClass.getSimpleName().toLowerCase().concat("s");
    }

    private String[] getTableFields(E entity) {
        Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                        f.setAccessible(true);
                        return this.getDatabaseFieldName(f.getName());
                });

        return new String[0];
    }

    private String getDatabaseFieldName(String name) {
        return name.replaceAll("([A-Z])", "_$1").toLowerCase();
    }


}
