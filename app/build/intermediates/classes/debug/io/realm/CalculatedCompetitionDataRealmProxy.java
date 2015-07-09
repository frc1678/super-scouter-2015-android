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

public class CalculatedCompetitionDataRealmProxy extends CalculatedCompetitionData {

    @Override
    public int getCachedData() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedCompetitionData").get("cachedData"));
    }

    @Override
    public void setCachedData(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedCompetitionData").get("cachedData"), (long) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_CalculatedCompetitionData")) {
            Table table = transaction.getTable("class_CalculatedCompetitionData");
            table.addColumn(ColumnType.INTEGER, "cachedData");
            return table;
        }
        return transaction.getTable("class_CalculatedCompetitionData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_CalculatedCompetitionData")) {
            Table table = transaction.getTable("class_CalculatedCompetitionData");
            if(table.getColumnCount() != 1) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 1; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("cachedData")) {
                throw new IllegalStateException("Missing column 'cachedData'");
            }
            if (columnTypes.get("cachedData") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'cachedData'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("cachedData");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("cachedData")) {
            setCachedData((int) json.getInt("cachedData"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("cachedData") && reader.peek() != JsonToken.NULL) {
                setCachedData((int) reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CalculatedCompetitionData = [");
        stringBuilder.append("{cachedData:");
        stringBuilder.append(getCachedData());
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
        CalculatedCompetitionDataRealmProxy aCalculatedCompetitionData = (CalculatedCompetitionDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCalculatedCompetitionData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCalculatedCompetitionData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCalculatedCompetitionData.row.getIndex()) return false;

        return true;
    }

}
