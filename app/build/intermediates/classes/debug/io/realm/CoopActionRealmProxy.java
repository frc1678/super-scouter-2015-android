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

public class CoopActionRealmProxy extends CoopAction {

    @Override
    public int getUniqueID() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CoopAction").get("uniqueID"));
    }

    @Override
    public void setUniqueID(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CoopAction").get("uniqueID"), (long) value);
    }

    @Override
    public int getNumTotes() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CoopAction").get("numTotes"));
    }

    @Override
    public void setNumTotes(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CoopAction").get("numTotes"), (long) value);
    }

    @Override
    public boolean isOnTop() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("CoopAction").get("onTop"));
    }

    @Override
    public void setOnTop(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("CoopAction").get("onTop"), (boolean) value);
    }

    @Override
    public boolean isDidSucceed() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("CoopAction").get("didSucceed"));
    }

    @Override
    public void setDidSucceed(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("CoopAction").get("didSucceed"), (boolean) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_CoopAction")) {
            Table table = transaction.getTable("class_CoopAction");
            table.addColumn(ColumnType.INTEGER, "uniqueID");
            table.addColumn(ColumnType.INTEGER, "numTotes");
            table.addColumn(ColumnType.BOOLEAN, "onTop");
            table.addColumn(ColumnType.BOOLEAN, "didSucceed");
            return table;
        }
        return transaction.getTable("class_CoopAction");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_CoopAction")) {
            Table table = transaction.getTable("class_CoopAction");
            if(table.getColumnCount() != 4) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("uniqueID")) {
                throw new IllegalStateException("Missing column 'uniqueID'");
            }
            if (columnTypes.get("uniqueID") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'uniqueID'");
            }
            if (!columnTypes.containsKey("numTotes")) {
                throw new IllegalStateException("Missing column 'numTotes'");
            }
            if (columnTypes.get("numTotes") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numTotes'");
            }
            if (!columnTypes.containsKey("onTop")) {
                throw new IllegalStateException("Missing column 'onTop'");
            }
            if (columnTypes.get("onTop") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'onTop'");
            }
            if (!columnTypes.containsKey("didSucceed")) {
                throw new IllegalStateException("Missing column 'didSucceed'");
            }
            if (columnTypes.get("didSucceed") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'didSucceed'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("uniqueID", "numTotes", "onTop", "didSucceed");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("uniqueID")) {
            setUniqueID((int) json.getInt("uniqueID"));
        }
        if (json.has("numTotes")) {
            setNumTotes((int) json.getInt("numTotes"));
        }
        if (json.has("onTop")) {
            setOnTop((boolean) json.getBoolean("onTop"));
        }
        if (json.has("didSucceed")) {
            setDidSucceed((boolean) json.getBoolean("didSucceed"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("uniqueID") && reader.peek() != JsonToken.NULL) {
                setUniqueID((int) reader.nextInt());
            } else if (name.equals("numTotes")  && reader.peek() != JsonToken.NULL) {
                setNumTotes((int) reader.nextInt());
            } else if (name.equals("onTop")  && reader.peek() != JsonToken.NULL) {
                setOnTop((boolean) reader.nextBoolean());
            } else if (name.equals("didSucceed")  && reader.peek() != JsonToken.NULL) {
                setDidSucceed((boolean) reader.nextBoolean());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CoopAction = [");
        stringBuilder.append("{uniqueID:");
        stringBuilder.append(getUniqueID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numTotes:");
        stringBuilder.append(getNumTotes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{onTop:");
        stringBuilder.append(isOnTop());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{didSucceed:");
        stringBuilder.append(isDidSucceed());
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
        CoopActionRealmProxy aCoopAction = (CoopActionRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCoopAction.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCoopAction.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCoopAction.row.getIndex()) return false;

        return true;
    }

}
