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
public class com_pdg_WhatsApp_model_EstadoRealmProxy extends com.pdg.WhatsApp.model.Estado
    implements RealmObjectProxy, com_pdg_WhatsApp_model_EstadoRealmProxyInterface {

    static final class EstadoColumnInfo extends ColumnInfo {
        long idColKey;
        long fotoColKey;
        long nombreUsuarioColKey;
        long tiempoColKey;

        EstadoColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Estado");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.fotoColKey = addColumnDetails("foto", "foto", objectSchemaInfo);
            this.nombreUsuarioColKey = addColumnDetails("nombreUsuario", "nombreUsuario", objectSchemaInfo);
            this.tiempoColKey = addColumnDetails("tiempo", "tiempo", objectSchemaInfo);
        }

        EstadoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new EstadoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final EstadoColumnInfo src = (EstadoColumnInfo) rawSrc;
            final EstadoColumnInfo dst = (EstadoColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.fotoColKey = src.fotoColKey;
            dst.nombreUsuarioColKey = src.nombreUsuarioColKey;
            dst.tiempoColKey = src.tiempoColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private EstadoColumnInfo columnInfo;
    private ProxyState<com.pdg.WhatsApp.model.Estado> proxyState;

    com_pdg_WhatsApp_model_EstadoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (EstadoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.pdg.WhatsApp.model.Estado>(this);
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
    public int realmGet$foto() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.fotoColKey);
    }

    @Override
    public void realmSet$foto(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.fotoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.fotoColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombreUsuario() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombreUsuarioColKey);
    }

    @Override
    public void realmSet$nombreUsuario(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombreUsuarioColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombreUsuarioColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombreUsuarioColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombreUsuarioColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tiempo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tiempoColKey);
    }

    @Override
    public void realmSet$tiempo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tiempoColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.tiempoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tiempoColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tiempoColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Estado", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "foto", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombreUsuario", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "tiempo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static EstadoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new EstadoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Estado";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Estado";
    }

    @SuppressWarnings("cast")
    public static com.pdg.WhatsApp.model.Estado createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.pdg.WhatsApp.model.Estado obj = null;
        if (update) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
            EstadoColumnInfo columnInfo = (EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.Estado.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.Estado.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_pdg_WhatsApp_model_EstadoRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) obj;
        if (json.has("foto")) {
            if (json.isNull("foto")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'foto' to null.");
            } else {
                objProxy.realmSet$foto((int) json.getInt("foto"));
            }
        }
        if (json.has("nombreUsuario")) {
            if (json.isNull("nombreUsuario")) {
                objProxy.realmSet$nombreUsuario(null);
            } else {
                objProxy.realmSet$nombreUsuario((String) json.getString("nombreUsuario"));
            }
        }
        if (json.has("tiempo")) {
            if (json.isNull("tiempo")) {
                objProxy.realmSet$tiempo(null);
            } else {
                objProxy.realmSet$tiempo((String) json.getString("tiempo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.pdg.WhatsApp.model.Estado createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.pdg.WhatsApp.model.Estado obj = new com.pdg.WhatsApp.model.Estado();
        final com_pdg_WhatsApp_model_EstadoRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) obj;
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
            } else if (name.equals("foto")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$foto((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'foto' to null.");
                }
            } else if (name.equals("nombreUsuario")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombreUsuario((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombreUsuario(null);
                }
            } else if (name.equals("tiempo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tiempo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tiempo(null);
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

    static com_pdg_WhatsApp_model_EstadoRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class), false, Collections.<String>emptyList());
        io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy obj = new io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.pdg.WhatsApp.model.Estado copyOrUpdate(Realm realm, EstadoColumnInfo columnInfo, com.pdg.WhatsApp.model.Estado object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.pdg.WhatsApp.model.Estado) cachedRealmObject;
        }

        com.pdg.WhatsApp.model.Estado realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.pdg.WhatsApp.model.Estado copy(Realm realm, EstadoColumnInfo columnInfo, com.pdg.WhatsApp.model.Estado newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.pdg.WhatsApp.model.Estado) cachedRealmObject;
        }

        com_pdg_WhatsApp_model_EstadoRealmProxyInterface unmanagedSource = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) newObject;

        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addInteger(columnInfo.fotoColKey, unmanagedSource.realmGet$foto());
        builder.addString(columnInfo.nombreUsuarioColKey, unmanagedSource.realmGet$nombreUsuario());
        builder.addString(columnInfo.tiempoColKey, unmanagedSource.realmGet$tiempo());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_pdg_WhatsApp_model_EstadoRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.pdg.WhatsApp.model.Estado object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        long tableNativePtr = table.getNativePtr();
        EstadoColumnInfo columnInfo = (EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Table.nativeSetLong(tableNativePtr, columnInfo.fotoColKey, objKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$foto(), false);
        String realmGet$nombreUsuario = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$nombreUsuario();
        if (realmGet$nombreUsuario != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, realmGet$nombreUsuario, false);
        }
        String realmGet$tiempo = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$tiempo();
        if (realmGet$tiempo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tiempoColKey, objKey, realmGet$tiempo, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        long tableNativePtr = table.getNativePtr();
        EstadoColumnInfo columnInfo = (EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.Estado object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.Estado) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Table.nativeSetLong(tableNativePtr, columnInfo.fotoColKey, objKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$foto(), false);
            String realmGet$nombreUsuario = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$nombreUsuario();
            if (realmGet$nombreUsuario != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, realmGet$nombreUsuario, false);
            }
            String realmGet$tiempo = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$tiempo();
            if (realmGet$tiempo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tiempoColKey, objKey, realmGet$tiempo, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.pdg.WhatsApp.model.Estado object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        long tableNativePtr = table.getNativePtr();
        EstadoColumnInfo columnInfo = (EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        Table.nativeSetLong(tableNativePtr, columnInfo.fotoColKey, objKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$foto(), false);
        String realmGet$nombreUsuario = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$nombreUsuario();
        if (realmGet$nombreUsuario != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, realmGet$nombreUsuario, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, false);
        }
        String realmGet$tiempo = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$tiempo();
        if (realmGet$tiempo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tiempoColKey, objKey, realmGet$tiempo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tiempoColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        long tableNativePtr = table.getNativePtr();
        EstadoColumnInfo columnInfo = (EstadoColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.Estado.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.Estado object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.Estado) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            Table.nativeSetLong(tableNativePtr, columnInfo.fotoColKey, objKey, ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$foto(), false);
            String realmGet$nombreUsuario = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$nombreUsuario();
            if (realmGet$nombreUsuario != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, realmGet$nombreUsuario, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreUsuarioColKey, objKey, false);
            }
            String realmGet$tiempo = ((com_pdg_WhatsApp_model_EstadoRealmProxyInterface) object).realmGet$tiempo();
            if (realmGet$tiempo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tiempoColKey, objKey, realmGet$tiempo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tiempoColKey, objKey, false);
            }
        }
    }

    public static com.pdg.WhatsApp.model.Estado createDetachedCopy(com.pdg.WhatsApp.model.Estado realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.pdg.WhatsApp.model.Estado unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.pdg.WhatsApp.model.Estado();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.pdg.WhatsApp.model.Estado) cachedObject.object;
            }
            unmanagedObject = (com.pdg.WhatsApp.model.Estado) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_pdg_WhatsApp_model_EstadoRealmProxyInterface unmanagedCopy = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) unmanagedObject;
        com_pdg_WhatsApp_model_EstadoRealmProxyInterface realmSource = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$foto(realmSource.realmGet$foto());
        unmanagedCopy.realmSet$nombreUsuario(realmSource.realmGet$nombreUsuario());
        unmanagedCopy.realmSet$tiempo(realmSource.realmGet$tiempo());

        return unmanagedObject;
    }

    static com.pdg.WhatsApp.model.Estado update(Realm realm, EstadoColumnInfo columnInfo, com.pdg.WhatsApp.model.Estado realmObject, com.pdg.WhatsApp.model.Estado newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_pdg_WhatsApp_model_EstadoRealmProxyInterface realmObjectTarget = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) realmObject;
        com_pdg_WhatsApp_model_EstadoRealmProxyInterface realmObjectSource = (com_pdg_WhatsApp_model_EstadoRealmProxyInterface) newObject;
        Table table = realm.getTable(com.pdg.WhatsApp.model.Estado.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.fotoColKey, realmObjectSource.realmGet$foto());
        builder.addString(columnInfo.nombreUsuarioColKey, realmObjectSource.realmGet$nombreUsuario());
        builder.addString(columnInfo.tiempoColKey, realmObjectSource.realmGet$tiempo());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Estado = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{foto:");
        stringBuilder.append(realmGet$foto());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombreUsuario:");
        stringBuilder.append(realmGet$nombreUsuario() != null ? realmGet$nombreUsuario() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tiempo:");
        stringBuilder.append(realmGet$tiempo() != null ? realmGet$tiempo() : "null");
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
        com_pdg_WhatsApp_model_EstadoRealmProxy aEstado = (com_pdg_WhatsApp_model_EstadoRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aEstado.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aEstado.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aEstado.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
