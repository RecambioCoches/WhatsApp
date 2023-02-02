package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_pdg_WhatsApp_model_ChatsRealmProxy extends com.pdg.WhatsApp.model.Chats
    implements RealmObjectProxy, com_pdg_WhatsApp_model_ChatsRealmProxyInterface {

    static final class ChatsColumnInfo extends ColumnInfo {
        long idColKey;
        long nombreChatColKey;
        long mensajesColKey;
        long imagenColKey;

        ChatsColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Chats");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombreChatColKey = addColumnDetails("nombreChat", "nombreChat", objectSchemaInfo);
            this.mensajesColKey = addColumnDetails("mensajes", "mensajes", objectSchemaInfo);
            this.imagenColKey = addColumnDetails("imagen", "imagen", objectSchemaInfo);
        }

        ChatsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChatsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChatsColumnInfo src = (ChatsColumnInfo) rawSrc;
            final ChatsColumnInfo dst = (ChatsColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nombreChatColKey = src.nombreChatColKey;
            dst.mensajesColKey = src.mensajesColKey;
            dst.imagenColKey = src.imagenColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChatsColumnInfo columnInfo;
    private ProxyState<com.pdg.WhatsApp.model.Chats> proxyState;
    private RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesRealmList;

    com_pdg_WhatsApp_model_ChatsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChatsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.pdg.WhatsApp.model.Chats>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombreChat() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombreChatColKey);
    }

    @Override
    public void realmSet$nombreChat(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombreChatColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombreChatColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombreChatColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombreChatColKey, value);
    }

    @Override
    public RealmList<com.pdg.WhatsApp.model.Mensaje> realmGet$mensajes() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (mensajesRealmList != null) {
            return mensajesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.mensajesColKey);
            mensajesRealmList = new RealmList<com.pdg.WhatsApp.model.Mensaje>(com.pdg.WhatsApp.model.Mensaje.class, osList, proxyState.getRealm$realm());
            return mensajesRealmList;
        }
    }

    @Override
    public void realmSet$mensajes(RealmList<com.pdg.WhatsApp.model.Mensaje> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("mensajes")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.pdg.WhatsApp.model.Mensaje> original = value;
                value = new RealmList<com.pdg.WhatsApp.model.Mensaje>();
                for (com.pdg.WhatsApp.model.Mensaje item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.mensajesColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.pdg.WhatsApp.model.Mensaje linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.pdg.WhatsApp.model.Mensaje linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$imagen() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.imagenColKey);
    }

    @Override
    public void realmSet$imagen(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.imagenColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.imagenColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Chats", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombreChat", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "mensajes", RealmFieldType.LIST, "Mensaje");
        builder.addPersistedProperty(NO_ALIAS, "imagen", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChatsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChatsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Chats";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Chats";
    }

    @SuppressWarnings("cast")
    public static com.pdg.WhatsApp.model.Chats createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.pdg.WhatsApp.model.Chats obj = null;
        if (update) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
            ChatsColumnInfo columnInfo = (ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("mensajes")) {
                excludeFields.add("mensajes");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.Chats.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.Chats.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_pdg_WhatsApp_model_ChatsRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) obj;
        if (json.has("nombreChat")) {
            if (json.isNull("nombreChat")) {
                objProxy.realmSet$nombreChat(null);
            } else {
                objProxy.realmSet$nombreChat((String) json.getString("nombreChat"));
            }
        }
        if (json.has("mensajes")) {
            if (json.isNull("mensajes")) {
                objProxy.realmSet$mensajes(null);
            } else {
                objProxy.realmGet$mensajes().clear();
                JSONArray array = json.getJSONArray("mensajes");
                for (int i = 0; i < array.length(); i++) {
                    com.pdg.WhatsApp.model.Mensaje item = com_pdg_WhatsApp_model_MensajeRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$mensajes().add(item);
                }
            }
        }
        if (json.has("imagen")) {
            if (json.isNull("imagen")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'imagen' to null.");
            } else {
                objProxy.realmSet$imagen((int) json.getInt("imagen"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.pdg.WhatsApp.model.Chats createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.pdg.WhatsApp.model.Chats obj = new com.pdg.WhatsApp.model.Chats();
        final com_pdg_WhatsApp_model_ChatsRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("nombreChat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombreChat((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombreChat(null);
                }
            } else if (name.equals("mensajes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$mensajes(null);
                } else {
                    objProxy.realmSet$mensajes(new RealmList<com.pdg.WhatsApp.model.Mensaje>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.pdg.WhatsApp.model.Mensaje item = com_pdg_WhatsApp_model_MensajeRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$mensajes().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("imagen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$imagen((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'imagen' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_pdg_WhatsApp_model_ChatsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class), false, Collections.<String>emptyList());
        io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy obj = new io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.pdg.WhatsApp.model.Chats copyOrUpdate(Realm realm, ChatsColumnInfo columnInfo, com.pdg.WhatsApp.model.Chats object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.pdg.WhatsApp.model.Chats) cachedRealmObject;
        }

        com.pdg.WhatsApp.model.Chats realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.pdg.WhatsApp.model.Chats copy(Realm realm, ChatsColumnInfo columnInfo, com.pdg.WhatsApp.model.Chats newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.pdg.WhatsApp.model.Chats) cachedRealmObject;
        }

        com_pdg_WhatsApp_model_ChatsRealmProxyInterface unmanagedSource = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nombreChatColKey, unmanagedSource.realmGet$nombreChat());
        builder.addInteger(columnInfo.imagenColKey, unmanagedSource.realmGet$imagen());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_pdg_WhatsApp_model_ChatsRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesUnmanagedList = unmanagedSource.realmGet$mensajes();
        if (mensajesUnmanagedList != null) {
            RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesManagedList = managedCopy.realmGet$mensajes();
            mensajesManagedList.clear();
            for (int i = 0; i < mensajesUnmanagedList.size(); i++) {
                com.pdg.WhatsApp.model.Mensaje mensajesUnmanagedItem = mensajesUnmanagedList.get(i);
                com.pdg.WhatsApp.model.Mensaje cachemensajes = (com.pdg.WhatsApp.model.Mensaje) cache.get(mensajesUnmanagedItem);
                if (cachemensajes != null) {
                    mensajesManagedList.add(cachemensajes);
                } else {
                    mensajesManagedList.add(com_pdg_WhatsApp_model_MensajeRealmProxy.copyOrUpdate(realm, (com_pdg_WhatsApp_model_MensajeRealmProxy.MensajeColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Mensaje.class), mensajesUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.pdg.WhatsApp.model.Chats object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        long tableNativePtr = table.getNativePtr();
        ChatsColumnInfo columnInfo = (ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$nombreChat = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$nombreChat();
        if (realmGet$nombreChat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreChatColKey, objKey, realmGet$nombreChat, false);
        }

        RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesList = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$mensajes();
        if (mensajesList != null) {
            OsList mensajesOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.mensajesColKey);
            for (com.pdg.WhatsApp.model.Mensaje mensajesItem : mensajesList) {
                Long cacheItemIndexmensajes = cache.get(mensajesItem);
                if (cacheItemIndexmensajes == null) {
                    cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insert(realm, mensajesItem, cache);
                }
                mensajesOsList.addRow(cacheItemIndexmensajes);
            }
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.imagenColKey, objKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$imagen(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        long tableNativePtr = table.getNativePtr();
        ChatsColumnInfo columnInfo = (ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.Chats object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.Chats) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$nombreChat = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$nombreChat();
            if (realmGet$nombreChat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreChatColKey, objKey, realmGet$nombreChat, false);
            }

            RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesList = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$mensajes();
            if (mensajesList != null) {
                OsList mensajesOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.mensajesColKey);
                for (com.pdg.WhatsApp.model.Mensaje mensajesItem : mensajesList) {
                    Long cacheItemIndexmensajes = cache.get(mensajesItem);
                    if (cacheItemIndexmensajes == null) {
                        cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insert(realm, mensajesItem, cache);
                    }
                    mensajesOsList.addRow(cacheItemIndexmensajes);
                }
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.imagenColKey, objKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$imagen(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.pdg.WhatsApp.model.Chats object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        long tableNativePtr = table.getNativePtr();
        ChatsColumnInfo columnInfo = (ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$nombreChat = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$nombreChat();
        if (realmGet$nombreChat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreChatColKey, objKey, realmGet$nombreChat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreChatColKey, objKey, false);
        }

        OsList mensajesOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.mensajesColKey);
        RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesList = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$mensajes();
        if (mensajesList != null && mensajesList.size() == mensajesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = mensajesList.size();
            for (int i = 0; i < objectCount; i++) {
                com.pdg.WhatsApp.model.Mensaje mensajesItem = mensajesList.get(i);
                Long cacheItemIndexmensajes = cache.get(mensajesItem);
                if (cacheItemIndexmensajes == null) {
                    cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, mensajesItem, cache);
                }
                mensajesOsList.setRow(i, cacheItemIndexmensajes);
            }
        } else {
            mensajesOsList.removeAll();
            if (mensajesList != null) {
                for (com.pdg.WhatsApp.model.Mensaje mensajesItem : mensajesList) {
                    Long cacheItemIndexmensajes = cache.get(mensajesItem);
                    if (cacheItemIndexmensajes == null) {
                        cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, mensajesItem, cache);
                    }
                    mensajesOsList.addRow(cacheItemIndexmensajes);
                }
            }
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.imagenColKey, objKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$imagen(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        long tableNativePtr = table.getNativePtr();
        ChatsColumnInfo columnInfo = (ChatsColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Chats.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.Chats object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.Chats) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$nombreChat = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$nombreChat();
            if (realmGet$nombreChat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreChatColKey, objKey, realmGet$nombreChat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreChatColKey, objKey, false);
            }

            OsList mensajesOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.mensajesColKey);
            RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesList = ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$mensajes();
            if (mensajesList != null && mensajesList.size() == mensajesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = mensajesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.pdg.WhatsApp.model.Mensaje mensajesItem = mensajesList.get(i);
                    Long cacheItemIndexmensajes = cache.get(mensajesItem);
                    if (cacheItemIndexmensajes == null) {
                        cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, mensajesItem, cache);
                    }
                    mensajesOsList.setRow(i, cacheItemIndexmensajes);
                }
            } else {
                mensajesOsList.removeAll();
                if (mensajesList != null) {
                    for (com.pdg.WhatsApp.model.Mensaje mensajesItem : mensajesList) {
                        Long cacheItemIndexmensajes = cache.get(mensajesItem);
                        if (cacheItemIndexmensajes == null) {
                            cacheItemIndexmensajes = com_pdg_WhatsApp_model_MensajeRealmProxy.insertOrUpdate(realm, mensajesItem, cache);
                        }
                        mensajesOsList.addRow(cacheItemIndexmensajes);
                    }
                }
            }

            Table.nativeSetLong(tableNativePtr, columnInfo.imagenColKey, objKey, ((com_pdg_WhatsApp_model_ChatsRealmProxyInterface) object).realmGet$imagen(), false);
        }
    }

    public static com.pdg.WhatsApp.model.Chats createDetachedCopy(com.pdg.WhatsApp.model.Chats realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.pdg.WhatsApp.model.Chats unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.pdg.WhatsApp.model.Chats();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.pdg.WhatsApp.model.Chats) cachedObject.object;
            }
            unmanagedObject = (com.pdg.WhatsApp.model.Chats) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_pdg_WhatsApp_model_ChatsRealmProxyInterface unmanagedCopy = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) unmanagedObject;
        com_pdg_WhatsApp_model_ChatsRealmProxyInterface realmSource = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombreChat(realmSource.realmGet$nombreChat());

        // Deep copy of mensajes
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$mensajes(null);
        } else {
            RealmList<com.pdg.WhatsApp.model.Mensaje> managedmensajesList = realmSource.realmGet$mensajes();
            RealmList<com.pdg.WhatsApp.model.Mensaje> unmanagedmensajesList = new RealmList<com.pdg.WhatsApp.model.Mensaje>();
            unmanagedCopy.realmSet$mensajes(unmanagedmensajesList);
            int nextDepth = currentDepth + 1;
            int size = managedmensajesList.size();
            for (int i = 0; i < size; i++) {
                com.pdg.WhatsApp.model.Mensaje item = com_pdg_WhatsApp_model_MensajeRealmProxy.createDetachedCopy(managedmensajesList.get(i), nextDepth, maxDepth, cache);
                unmanagedmensajesList.add(item);
            }
        }
        unmanagedCopy.realmSet$imagen(realmSource.realmGet$imagen());

        return unmanagedObject;
    }

    static com.pdg.WhatsApp.model.Chats update(Realm realm, ChatsColumnInfo columnInfo, com.pdg.WhatsApp.model.Chats realmObject, com.pdg.WhatsApp.model.Chats newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_pdg_WhatsApp_model_ChatsRealmProxyInterface realmObjectTarget = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) realmObject;
        com_pdg_WhatsApp_model_ChatsRealmProxyInterface realmObjectSource = (com_pdg_WhatsApp_model_ChatsRealmProxyInterface) newObject;
        Table table = realm.getTable(com.pdg.WhatsApp.model.Chats.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombreChatColKey, realmObjectSource.realmGet$nombreChat());

        RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesUnmanagedList = realmObjectSource.realmGet$mensajes();
        if (mensajesUnmanagedList != null) {
            RealmList<com.pdg.WhatsApp.model.Mensaje> mensajesManagedCopy = new RealmList<com.pdg.WhatsApp.model.Mensaje>();
            for (int i = 0; i < mensajesUnmanagedList.size(); i++) {
                com.pdg.WhatsApp.model.Mensaje mensajesItem = mensajesUnmanagedList.get(i);
                com.pdg.WhatsApp.model.Mensaje cachemensajes = (com.pdg.WhatsApp.model.Mensaje) cache.get(mensajesItem);
                if (cachemensajes != null) {
                    mensajesManagedCopy.add(cachemensajes);
                } else {
                    mensajesManagedCopy.add(com_pdg_WhatsApp_model_MensajeRealmProxy.copyOrUpdate(realm, (com_pdg_WhatsApp_model_MensajeRealmProxy.MensajeColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Mensaje.class), mensajesItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.mensajesColKey, mensajesManagedCopy);
        } else {
            builder.addObjectList(columnInfo.mensajesColKey, new RealmList<com.pdg.WhatsApp.model.Mensaje>());
        }
        builder.addInteger(columnInfo.imagenColKey, realmObjectSource.realmGet$imagen());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Chats = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombreChat:");
        stringBuilder.append(realmGet$nombreChat() != null ? realmGet$nombreChat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mensajes:");
        stringBuilder.append("RealmList<Mensaje>[").append(realmGet$mensajes().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imagen:");
        stringBuilder.append(realmGet$imagen());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_pdg_WhatsApp_model_ChatsRealmProxy aChats = (com_pdg_WhatsApp_model_ChatsRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aChats.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChats.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aChats.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
