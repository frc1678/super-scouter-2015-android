package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObject;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.*;
import org.citruscircuits.realm.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReconAcquisitionRealmProxy extends ReconAcquisition {

    @Override
    public int getUniqueID() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("ReconAcquisition").get("uniqueID"));
    }

    @Override
    public void setUniqueID(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("ReconAcquisition").get("uniqueID"), (long) value);
    }

    @Override
    public int getNumReconsAcquired() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("ReconAcquisition").get("numReconsAcquired"));
    }

    @Override
    public void setNumReconsAcquired(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("ReconAcquisition").get("numReconsAcquired"), (long) value);
    }

    @Override
    public boolean isAcquiredMiddle() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("ReconAcquisition").get("acquiredMiddle"));
    }

    @Override
    public void setAcquiredMiddle(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("ReconAcquisition").get("acquiredMiddle"), (boolean) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_ReconAcquisition")) {
            Table table = transaction.getTable("class_ReconAcquisition");
            table.addColumn(ColumnType.INTEGER, "uniqueID");
            table.addColumn(ColumnType.INTEGER, "numReconsAcquired");
            table.addColumn(ColumnType.BOOLEAN, "acquiredMiddle");
            return table;
        }
        return transaction.getTable("class_ReconAcquisition");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_ReconAcquisition")) {
            Table table = transaction.getTable("class_ReconAcquisition");
            if(table.getColumnCount() != 3) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("uniqueID")) {
                throw new IllegalStateException("Missing column 'uniqueID'");
            }
            if (columnTypes.get("uniqueID") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'uniqueID'");
            }
            if (!columnTypes.containsKey("numReconsAcquired")) {
                throw new IllegalStateException("Missing column 'numReconsAcquired'");
            }
            if (columnTypes.get("numReconsAcquired") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numReconsAcquired'");
            }
            if (!columnTypes.containsKey("acquiredMiddle")) {
                throw new IllegalStateException("Missing column 'acquiredMiddle'");
            }
            if (columnTypes.get("acquiredMiddle") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'acquiredMiddle'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("uniqueID", "numReconsAcquired", "acquiredMiddle");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("uniqueID")) {
            setUniqueID((int) json.getInt("uniqueID"));
        }
        if (json.has("numReconsAcquired")) {
            setNumReconsAcquired((int) json.getInt("numReconsAcquired"));
        }
        if (json.has("acquiredMiddle")) {
            setAcquiredMiddle((boolean) json.getBoolean("acquiredMiddle"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("uniqueID") && reader.peek() != JsonToken.NULL) {
                setUniqueID((int) reader.nextInt());
            } else if (name.equals("numReconsAcquired")  && reader.peek() != JsonToken.NULL) {
                setNumReconsAcquired((int) reader.nextInt());
            } else if (name.equals("acquiredMiddle")  && reader.peek() != JsonToken.NULL) {
                setAcquiredMiddle((boolean) reader.nextBoolean());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ReconAcquisition = [");
        stringBuilder.append("{uniqueID:");
        stringBuilder.append(getUniqueID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numReconsAcquired:");
        stringBuilder.append(getNumReconsAcquired());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{acquiredMiddle:");
        stringBuilder.append(isAcquiredMiddle());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReconAcquisitionRealmProxy aReconAcquisition = (ReconAcquisitionRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aReconAcquisition.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aReconAcquisition.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aReconAcquisition.row.getIndex()) return false;

        return true;
    }

}
