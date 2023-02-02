package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(5);
        modelClasses.add(com.pdg.WhatsApp.model.Chats.class);
        modelClasses.add(com.pdg.WhatsApp.model.Llamada.class);
        modelClasses.add(com.pdg.WhatsApp.model.Estado.class);
        modelClasses.add(com.pdg.WhatsApp.model.Mensaje.class);
        modelClasses.add(com.pdg.WhatsApp.model.User.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(5);
        infoMap.put(com.pdg.WhatsApp.model.Chats.class, io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.pdg.WhatsApp.model.Llamada.class, io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.pdg.WhatsApp.model.Estado.class, io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.pdg.WhatsApp.model.Mensaje.class, io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.pdg.WhatsApp.model.User.class, io.realm.com_pdg_WhatsApp_model_UserRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return io.realm.com_pdg_WhatsApp_model_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return "Chats";
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return "Llamada";
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return "Estado";
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return "Mensaje";
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return "User";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("Chats")) {
            return com.pdg.WhatsApp.model.Chats.class;
        }
        if (className.equals("Llamada")) {
            return com.pdg.WhatsApp.model.Llamada.class;
        }
        if (className.equals("Estado")) {
            return com.pdg.WhatsApp.model.Estado.class;
        }
        if (className.equals("Mensaje")) {
            return com.pdg.WhatsApp.model.Mensaje.class;
        }
        if (className.equals("User")) {
            return com.pdg.WhatsApp.model.User.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return com.pdg.WhatsApp.model.Chats.class.isAssignableFrom(clazz)
                || com.pdg.WhatsApp.model.Llamada.class.isAssignableFrom(clazz)
                || com.pdg.WhatsApp.model.Estado.class.isAssignableFrom(clazz)
                || com.pdg.WhatsApp.model.Mensaje.class.isAssignableFrom(clazz)
                || com.pdg.WhatsApp.model.User.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
                return clazz.cast(new io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy());
            }
            if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
                return clazz.cast(new io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy());
            }
            if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
                return clazz.cast(new io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy());
            }
            if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
                return clazz.cast(new io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy());
            }
            if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
                return clazz.cast(new io.realm.com_pdg_WhatsApp_model_UserRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            com_pdg_WhatsApp_model_ChatsRealmProxy.ChatsColumnInfo columnInfo = (com_pdg_WhatsApp_model_ChatsRealmProxy.ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.copyOrUpdate(realm, columnInfo, (com.pdg.WhatsApp.model.Chats) obj, update, cache, flags));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            com_pdg_WhatsApp_model_LlamadaRealmProxy.LlamadaColumnInfo columnInfo = (com_pdg_WhatsApp_model_LlamadaRealmProxy.LlamadaColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Llamada.class);
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.copyOrUpdate(realm, columnInfo, (com.pdg.WhatsApp.model.Llamada) obj, update, cache, flags));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            com_pdg_WhatsApp_model_EstadoRealmProxy.EstadoColumnInfo columnInfo = (com_pdg_WhatsApp_model_EstadoRealmProxy.EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.copyOrUpdate(realm, columnInfo, (com.pdg.WhatsApp.model.Estado) obj, update, cache, flags));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            com_pdg_WhatsApp_model_MensajeRealmProxy.MensajeColumnInfo columnInfo = (com_pdg_WhatsApp_model_MensajeRealmProxy.MensajeColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Mensaje.class);
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.copyOrUpdate(realm, columnInfo, (com.pdg.WhatsApp.model.Mensaje) obj, update, cache, flags));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            com_pdg_WhatsApp_model_UserRealmProxy.UserColumnInfo columnInfo = (com_pdg_WhatsApp_model_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_UserRealmProxy.copyOrUpdate(realm, columnInfo, (com.pdg.WhatsApp.model.User) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Chats) object, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Llamada) object, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Estado) object, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Mensaje) object, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insert(realm, (com.pdg.WhatsApp.model.User) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
                io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Chats) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
                io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Llamada) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
                io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Estado) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
                io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insert(realm, (com.pdg.WhatsApp.model.Mensaje) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
                io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insert(realm, (com.pdg.WhatsApp.model.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
                    io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
                    io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
                    io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
                    io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
                    io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Chats) obj, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Llamada) obj, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Estado) obj, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Mensaje) obj, cache);
        } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.User) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
                io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Chats) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
                io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Llamada) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
                io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Estado) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
                io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.Mensaje) object, cache);
            } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
                io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insertOrUpdate(realm, (com.pdg.WhatsApp.model.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
                    io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
                    io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
                    io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
                    io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
                    io.realm.com_pdg_WhatsApp_model_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy.createDetachedCopy((com.pdg.WhatsApp.model.Chats) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_LlamadaRealmProxy.createDetachedCopy((com.pdg.WhatsApp.model.Llamada) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy.createDetachedCopy((com.pdg.WhatsApp.model.Estado) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_MensajeRealmProxy.createDetachedCopy((com.pdg.WhatsApp.model.Mensaje) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return clazz.cast(io.realm.com_pdg_WhatsApp_model_UserRealmProxy.createDetachedCopy((com.pdg.WhatsApp.model.User) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            return false;
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            return false;
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            return false;
        }
        if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            return false;
        }
        if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(com.pdg.WhatsApp.model.Chats.class)) {
            throw getNotEmbeddedClassException("com.pdg.WhatsApp.model.Chats");
        } else if (clazz.equals(com.pdg.WhatsApp.model.Llamada.class)) {
            throw getNotEmbeddedClassException("com.pdg.WhatsApp.model.Llamada");
        } else if (clazz.equals(com.pdg.WhatsApp.model.Estado.class)) {
            throw getNotEmbeddedClassException("com.pdg.WhatsApp.model.Estado");
        } else if (clazz.equals(com.pdg.WhatsApp.model.Mensaje.class)) {
            throw getNotEmbeddedClassException("com.pdg.WhatsApp.model.Mensaje");
        } else if (clazz.equals(com.pdg.WhatsApp.model.User.class)) {
            throw getNotEmbeddedClassException("com.pdg.WhatsApp.model.User");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
