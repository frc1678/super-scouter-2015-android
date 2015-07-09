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

public class CalculatedMatchDataRealmProxy extends CalculatedMatchData {

    @Override
    public int getPredictedRedScore() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedMatchData").get("predictedRedScore"));
    }

    @Override
    public void setPredictedRedScore(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedMatchData").get("predictedRedScore"), (long) value);
    }

    @Override
    public int getPredictedBlueScore() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedMatchData").get("predictedBlueScore"));
    }

    @Override
    public void setPredictedBlueScore(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedMatchData").get("predictedBlueScore"), (long) value);
    }

    @Override
    public String getBestRedAutoStrategy() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("CalculatedMatchData").get("bestRedAutoStrategy"));
    }

    @Override
    public void setBestRedAutoStrategy(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("CalculatedMatchData").get("bestRedAutoStrategy"), (String) value);
    }

    @Override
    public String getBestBlueAutoStrategy() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("CalculatedMatchData").get("bestBlueAutoStrategy"));
    }

    @Override
    public void setBestBlueAutoStrategy(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("CalculatedMatchData").get("bestBlueAutoStrategy"), (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_CalculatedMatchData")) {
            Table table = transaction.getTable("class_CalculatedMatchData");
            table.addColumn(ColumnType.INTEGER, "predictedRedScore");
            table.addColumn(ColumnType.INTEGER, "predictedBlueScore");
            table.addColumn(ColumnType.STRING, "bestRedAutoStrategy");
            table.addColumn(ColumnType.STRING, "bestBlueAutoStrategy");
            return table;
        }
        return transaction.getTable("class_CalculatedMatchData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_CalculatedMatchData")) {
            Table table = transaction.getTable("class_CalculatedMatchData");
            if(table.getColumnCount() != 4) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("predictedRedScore")) {
                throw new IllegalStateException("Missing column 'predictedRedScore'");
            }
            if (columnTypes.get("predictedRedScore") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'predictedRedScore'");
            }
            if (!columnTypes.containsKey("predictedBlueScore")) {
                throw new IllegalStateException("Missing column 'predictedBlueScore'");
            }
            if (columnTypes.get("predictedBlueScore") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'predictedBlueScore'");
            }
            if (!columnTypes.containsKey("bestRedAutoStrategy")) {
                throw new IllegalStateException("Missing column 'bestRedAutoStrategy'");
            }
            if (columnTypes.get("bestRedAutoStrategy") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'bestRedAutoStrategy'");
            }
            if (!columnTypes.containsKey("bestBlueAutoStrategy")) {
                throw new IllegalStateException("Missing column 'bestBlueAutoStrategy'");
            }
            if (columnTypes.get("bestBlueAutoStrategy") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'bestBlueAutoStrategy'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("predictedRedScore", "predictedBlueScore", "bestRedAutoStrategy", "bestBlueAutoStrategy");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("predictedRedScore")) {
            setPredictedRedScore((int) json.getInt("predictedRedScore"));
        }
        if (json.has("predictedBlueScore")) {
            setPredictedBlueScore((int) json.getInt("predictedBlueScore"));
        }
        if (json.has("bestRedAutoStrategy")) {
            setBestRedAutoStrategy((String) json.getString("bestRedAutoStrategy"));
        }
        if (json.has("bestBlueAutoStrategy")) {
            setBestBlueAutoStrategy((String) json.getString("bestBlueAutoStrategy"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("predictedRedScore") && reader.peek() != JsonToken.NULL) {
                setPredictedRedScore((int) reader.nextInt());
            } else if (name.equals("predictedBlueScore")  && reader.peek() != JsonToken.NULL) {
                setPredictedBlueScore((int) reader.nextInt());
            } else if (name.equals("bestRedAutoStrategy")  && reader.peek() != JsonToken.NULL) {
                setBestRedAutoStrategy((String) reader.nextString());
            } else if (name.equals("bestBlueAutoStrategy")  && reader.peek() != JsonToken.NULL) {
                setBestBlueAutoStrategy((String) reader.nextString());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CalculatedMatchData = [");
        stringBuilder.append("{predictedRedScore:");
        stringBuilder.append(getPredictedRedScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{predictedBlueScore:");
        stringBuilder.append(getPredictedBlueScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bestRedAutoStrategy:");
        stringBuilder.append(getBestRedAutoStrategy());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bestBlueAutoStrategy:");
        stringBuilder.append(getBestBlueAutoStrategy());
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
        CalculatedMatchDataRealmProxy aCalculatedMatchData = (CalculatedMatchDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCalculatedMatchData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCalculatedMatchData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCalculatedMatchData.row.getIndex()) return false;

        return true;
    }

}
