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
public class com_pdg_WhatsApp_model_UserRealmProxy extends com.pdg.WhatsApp.model.User
    implements RealmObjectProxy, com_pdg_WhatsApp_model_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long idColKey;
        long nombreColKey;
        long grupoColKey;
        long emailColKey;
        long PasswordColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombreColKey = addColumnDetails("nombre", "nombre", objectSchemaInfo);
            this.grupoColKey = addColumnDetails("grupo", "grupo", objectSchemaInfo);
            this.emailColKey = addColumnDetails("email", "email", objectSchemaInfo);
            this.PasswordColKey = addColumnDetails("Password", "Password", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nombreColKey = src.nombreColKey;
            dst.grupoColKey = src.grupoColKey;
            dst.emailColKey = src.emailColKey;
            dst.PasswordColKey = src.PasswordColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.pdg.WhatsApp.model.User> proxyState;

    com_pdg_WhatsApp_model_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.pdg.WhatsApp.model.User>(this);
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
    public String realmGet$nombre() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombreColKey);
    }

    @Override
    public void realmSet$nombre(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombreColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombreColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombreColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombreColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$grupo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.grupoColKey);
    }

    @Override
    public void realmSet$grupo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.grupoColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.grupoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.grupoColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.grupoColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailColKey);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PasswordColKey);
    }

    @Override
    public void realmSet$Password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PasswordColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.PasswordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PasswordColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PasswordColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "User", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "nombre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "grupo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "Password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.pdg.WhatsApp.model.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.pdg.WhatsApp.model.User obj = null;
        if (update) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_pdg_WhatsApp_model_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_pdg_WhatsApp_model_UserRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_pdg_WhatsApp_model_UserRealmProxy) realm.createObjectInternal(com.pdg.WhatsApp.model.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_pdg_WhatsApp_model_UserRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_UserRealmProxyInterface) obj;
        if (json.has("nombre")) {
            if (json.isNull("nombre")) {
                objProxy.realmSet$nombre(null);
            } else {
                objProxy.realmSet$nombre((String) json.getString("nombre"));
            }
        }
        if (json.has("grupo")) {
            if (json.isNull("grupo")) {
                objProxy.realmSet$grupo(null);
            } else {
                objProxy.realmSet$grupo((String) json.getString("grupo"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("Password")) {
            if (json.isNull("Password")) {
                objProxy.realmSet$Password(null);
            } else {
                objProxy.realmSet$Password((String) json.getString("Password"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.pdg.WhatsApp.model.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.pdg.WhatsApp.model.User obj = new com.pdg.WhatsApp.model.User();
        final com_pdg_WhatsApp_model_UserRealmProxyInterface objProxy = (com_pdg_WhatsApp_model_UserRealmProxyInterface) obj;
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
            } else if (name.equals("nombre")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre(null);
                }
            } else if (name.equals("grupo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$grupo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$grupo(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("Password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Password(null);
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

    static com_pdg_WhatsApp_model_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class), false, Collections.<String>emptyList());
        io.realm.com_pdg_WhatsApp_model_UserRealmProxy obj = new io.realm.com_pdg_WhatsApp_model_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.pdg.WhatsApp.model.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.pdg.WhatsApp.model.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.pdg.WhatsApp.model.User) cachedRealmObject;
        }

        com.pdg.WhatsApp.model.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_pdg_WhatsApp_model_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.pdg.WhatsApp.model.User copy(Realm realm, UserColumnInfo columnInfo, com.pdg.WhatsApp.model.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.pdg.WhatsApp.model.User) cachedRealmObject;
        }

        com_pdg_WhatsApp_model_UserRealmProxyInterface unmanagedSource = (com_pdg_WhatsApp_model_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, unmanagedSource.realmGet$nombre());
        builder.addString(columnInfo.grupoColKey, unmanagedSource.realmGet$grupo());
        builder.addString(columnInfo.emailColKey, unmanagedSource.realmGet$email());
        builder.addString(columnInfo.PasswordColKey, unmanagedSource.realmGet$Password());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_pdg_WhatsApp_model_UserRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.pdg.WhatsApp.model.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        }
        String realmGet$grupo = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$grupo();
        if (realmGet$grupo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.grupoColKey, objKey, realmGet$grupo, false);
        }
        String realmGet$email = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        }
        String realmGet$Password = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$Password();
        if (realmGet$Password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PasswordColKey, objKey, realmGet$Password, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.User object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            }
            String realmGet$grupo = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$grupo();
            if (realmGet$grupo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.grupoColKey, objKey, realmGet$grupo, false);
            }
            String realmGet$email = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            }
            String realmGet$Password = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$Password();
            if (realmGet$Password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PasswordColKey, objKey, realmGet$Password, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.pdg.WhatsApp.model.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$nombre = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$nombre();
        if (realmGet$nombre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
        }
        String realmGet$grupo = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$grupo();
        if (realmGet$grupo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.grupoColKey, objKey, realmGet$grupo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.grupoColKey, objKey, false);
        }
        String realmGet$email = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
        }
        String realmGet$Password = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$Password();
        if (realmGet$Password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PasswordColKey, objKey, realmGet$Password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PasswordColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.pdg.WhatsApp.model.User.class);
        long pkColumnKey = columnInfo.idColKey;
        com.pdg.WhatsApp.model.User object = null;
        while (objects.hasNext()) {
            object = (com.pdg.WhatsApp.model.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$nombre = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$nombre();
            if (realmGet$nombre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombreColKey, objKey, realmGet$nombre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombreColKey, objKey, false);
            }
            String realmGet$grupo = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$grupo();
            if (realmGet$grupo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.grupoColKey, objKey, realmGet$grupo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.grupoColKey, objKey, false);
            }
            String realmGet$email = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
            }
            String realmGet$Password = ((com_pdg_WhatsApp_model_UserRealmProxyInterface) object).realmGet$Password();
            if (realmGet$Password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PasswordColKey, objKey, realmGet$Password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PasswordColKey, objKey, false);
            }
        }
    }

    public static com.pdg.WhatsApp.model.User createDetachedCopy(com.pdg.WhatsApp.model.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.pdg.WhatsApp.model.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.pdg.WhatsApp.model.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.pdg.WhatsApp.model.User) cachedObject.object;
            }
            unmanagedObject = (com.pdg.WhatsApp.model.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_pdg_WhatsApp_model_UserRealmProxyInterface unmanagedCopy = (com_pdg_WhatsApp_model_UserRealmProxyInterface) unmanagedObject;
        com_pdg_WhatsApp_model_UserRealmProxyInterface realmSource = (com_pdg_WhatsApp_model_UserRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombre(realmSource.realmGet$nombre());
        unmanagedCopy.realmSet$grupo(realmSource.realmGet$grupo());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$Password(realmSource.realmGet$Password());

        return unmanagedObject;
    }

    static com.pdg.WhatsApp.model.User update(Realm realm, UserColumnInfo columnInfo, com.pdg.WhatsApp.model.User realmObject, com.pdg.WhatsApp.model.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_pdg_WhatsApp_model_UserRealmProxyInterface realmObjectTarget = (com_pdg_WhatsApp_model_UserRealmProxyInterface) realmObject;
        com_pdg_WhatsApp_model_UserRealmProxyInterface realmObjectSource = (com_pdg_WhatsApp_model_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.pdg.WhatsApp.model.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombreColKey, realmObjectSource.realmGet$nombre());
        builder.addString(columnInfo.grupoColKey, realmObjectSource.realmGet$grupo());
        builder.addString(columnInfo.emailColKey, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.PasswordColKey, realmObjectSource.realmGet$Password());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre:");
        stringBuilder.append(realmGet$nombre() != null ? realmGet$nombre() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{grupo:");
        stringBuilder.append(realmGet$grupo() != null ? realmGet$grupo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Password:");
        stringBuilder.append(realmGet$Password() != null ? realmGet$Password() : "null");
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
        com_pdg_WhatsApp_model_UserRealmProxy aUser = (com_pdg_WhatsApp_model_UserRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUser.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUser.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
