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

public class CalculatedTeamInMatchDataRealmProxy extends CalculatedTeamInMatchData {

    @Override
    public int getNumReconsPickedUp() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedTeamInMatchData").get("numReconsPickedUp"));
    }

    @Override
    public void setNumReconsPickedUp(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedTeamInMatchData").get("numReconsPickedUp"), (long) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_CalculatedTeamInMatchData")) {
            Table table = transaction.getTable("class_CalculatedTeamInMatchData");
            table.addColumn(ColumnType.INTEGER, "numReconsPickedUp");
            return table;
        }
        return transaction.getTable("class_CalculatedTeamInMatchData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_CalculatedTeamInMatchData")) {
            Table table = transaction.getTable("class_CalculatedTeamInMatchData");
            if(table.getColumnCount() != 1) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 1; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("numReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'numReconsPickedUp'");
            }
            if (columnTypes.get("numReconsPickedUp") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numReconsPickedUp'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("numReconsPickedUp");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("numReconsPickedUp")) {
            setNumReconsPickedUp((int) json.getInt("numReconsPickedUp"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("numReconsPickedUp") && reader.peek() != JsonToken.NULL) {
                setNumReconsPickedUp((int) reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CalculatedTeamInMatchData = [");
        stringBuilder.append("{numReconsPickedUp:");
        stringBuilder.append(getNumReconsPickedUp());
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
        CalculatedTeamInMatchDataRealmProxy aCalculatedTeamInMatchData = (CalculatedTeamInMatchDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCalculatedTeamInMatchData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCalculatedTeamInMatchData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCalculatedTeamInMatchData.row.getIndex()) return false;

        return true;
    }

}
