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

public class UploadedTeamInMatchDataRealmProxy extends UploadedTeamInMatchData {

    @Override
    public boolean isStackedToteSet() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("stackedToteSet"));
    }

    @Override
    public void setStackedToteSet(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("stackedToteSet"), (boolean) value);
    }

    @Override
    public int getNumContainersMovedIntoAutoZone() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numContainersMovedIntoAutoZone"));
    }

    @Override
    public void setNumContainersMovedIntoAutoZone(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numContainersMovedIntoAutoZone"), (long) value);
    }

    @Override
    public int getNumTotesStacked() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesStacked"));
    }

    @Override
    public void setNumTotesStacked(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesStacked"), (long) value);
    }

    @Override
    public int getNumReconLevels() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numReconLevels"));
    }

    @Override
    public void setNumReconLevels(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numReconLevels"), (long) value);
    }

    @Override
    public int getNumNoodlesContributed() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numNoodlesContributed"));
    }

    @Override
    public void setNumNoodlesContributed(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numNoodlesContributed"), (long) value);
    }

    @Override
    public int getNumReconsStacked() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numReconsStacked"));
    }

    @Override
    public void setNumReconsStacked(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numReconsStacked"), (long) value);
    }

    @Override
    public int getNumHorizontalReconsPickedUp() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numHorizontalReconsPickedUp"));
    }

    @Override
    public void setNumHorizontalReconsPickedUp(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numHorizontalReconsPickedUp"), (long) value);
    }

    @Override
    public int getNumVerticalReconsPickedUp() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numVerticalReconsPickedUp"));
    }

    @Override
    public void setNumVerticalReconsPickedUp(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numVerticalReconsPickedUp"), (long) value);
    }

    @Override
    public int getNumTotesPickedUpFromGround() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesPickedUpFromGround"));
    }

    @Override
    public void setNumTotesPickedUpFromGround(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesPickedUpFromGround"), (long) value);
    }

    @Override
    public int getNumLitterDropped() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numLitterDropped"));
    }

    @Override
    public void setNumLitterDropped(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numLitterDropped"), (long) value);
    }

    @Override
    public int getNumStacksDamaged() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numStacksDamaged"));
    }

    @Override
    public void setNumStacksDamaged(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numStacksDamaged"), (long) value);
    }

    @Override
    public RealmList<org.citruscircuits.realm.CoopAction> getCoopActions() {
        return new RealmList<CoopAction>(CoopAction.class, row.getLinkList(Realm.columnIndices.get("UploadedTeamInMatchData").get("coopActions")), realm);
    }

    @Override
    public void setCoopActions(RealmList<org.citruscircuits.realm.CoopAction> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("UploadedTeamInMatchData").get("coopActions"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public int getMaxFieldToteHeight() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("maxFieldToteHeight"));
    }

    @Override
    public void setMaxFieldToteHeight(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("maxFieldToteHeight"), (long) value);
    }

    @Override
    public int getMaxReconHeight() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("maxReconHeight"));
    }

    @Override
    public void setMaxReconHeight(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("maxReconHeight"), (long) value);
    }

    @Override
    public int getNumTeleopReconsFromStep() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTeleopReconsFromStep"));
    }

    @Override
    public void setNumTeleopReconsFromStep(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTeleopReconsFromStep"), (long) value);
    }

    @Override
    public int getNumTotesFromHP() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesFromHP"));
    }

    @Override
    public void setNumTotesFromHP(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numTotesFromHP"), (long) value);
    }

    @Override
    public RealmList<org.citruscircuits.realm.ReconAcquisition> getReconAcquisitions() {
        return new RealmList<ReconAcquisition>(ReconAcquisition.class, row.getLinkList(Realm.columnIndices.get("UploadedTeamInMatchData").get("reconAcquisitions")), realm);
    }

    @Override
    public void setReconAcquisitions(RealmList<org.citruscircuits.realm.ReconAcquisition> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("UploadedTeamInMatchData").get("reconAcquisitions"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public int getAgility() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("agility"));
    }

    @Override
    public void setAgility(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("agility"), (long) value);
    }

    @Override
    public int getStackPlacing() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("stackPlacing"));
    }

    @Override
    public void setStackPlacing(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("stackPlacing"), (long) value);
    }

    @Override
    public int getHumanPlayerLoading() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("humanPlayerLoading"));
    }

    @Override
    public void setHumanPlayerLoading(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("humanPlayerLoading"), (long) value);
    }

    @Override
    public boolean isIncapacitated() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("incapacitated"));
    }

    @Override
    public void setIncapacitated(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("incapacitated"), (boolean) value);
    }

    @Override
    public boolean isDisabled() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("disabled"));
    }

    @Override
    public void setDisabled(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("UploadedTeamInMatchData").get("disabled"), (boolean) value);
    }

    @Override
    public String getMiscellaneousNotes() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("UploadedTeamInMatchData").get("miscellaneousNotes"));
    }

    @Override
    public void setMiscellaneousNotes(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("UploadedTeamInMatchData").get("miscellaneousNotes"), (String) value);
    }

    @Override
    public int getNumStepReconAcquisitionsFailed() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numStepReconAcquisitionsFailed"));
    }

    @Override
    public void setNumStepReconAcquisitionsFailed(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numStepReconAcquisitionsFailed"), (long) value);
    }

    @Override
    public int getNumSixStacksCapped() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numSixStacksCapped"));
    }

    @Override
    public void setNumSixStacksCapped(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("UploadedTeamInMatchData").get("numSixStacksCapped"), (long) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_UploadedTeamInMatchData")) {
            Table table = transaction.getTable("class_UploadedTeamInMatchData");
            table.addColumn(ColumnType.BOOLEAN, "stackedToteSet");
            table.addColumn(ColumnType.INTEGER, "numContainersMovedIntoAutoZone");
            table.addColumn(ColumnType.INTEGER, "numTotesStacked");
            table.addColumn(ColumnType.INTEGER, "numReconLevels");
            table.addColumn(ColumnType.INTEGER, "numNoodlesContributed");
            table.addColumn(ColumnType.INTEGER, "numReconsStacked");
            table.addColumn(ColumnType.INTEGER, "numHorizontalReconsPickedUp");
            table.addColumn(ColumnType.INTEGER, "numVerticalReconsPickedUp");
            table.addColumn(ColumnType.INTEGER, "numTotesPickedUpFromGround");
            table.addColumn(ColumnType.INTEGER, "numLitterDropped");
            table.addColumn(ColumnType.INTEGER, "numStacksDamaged");
            if (!transaction.hasTable("class_CoopAction")) {
                CoopActionRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "coopActions", transaction.getTable("class_CoopAction"));
            table.addColumn(ColumnType.INTEGER, "maxFieldToteHeight");
            table.addColumn(ColumnType.INTEGER, "maxReconHeight");
            table.addColumn(ColumnType.INTEGER, "numTeleopReconsFromStep");
            table.addColumn(ColumnType.INTEGER, "numTotesFromHP");
            if (!transaction.hasTable("class_ReconAcquisition")) {
                ReconAcquisitionRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "reconAcquisitions", transaction.getTable("class_ReconAcquisition"));
            table.addColumn(ColumnType.INTEGER, "agility");
            table.addColumn(ColumnType.INTEGER, "stackPlacing");
            table.addColumn(ColumnType.INTEGER, "humanPlayerLoading");
            table.addColumn(ColumnType.BOOLEAN, "incapacitated");
            table.addColumn(ColumnType.BOOLEAN, "disabled");
            table.addColumn(ColumnType.STRING, "miscellaneousNotes");
            table.addColumn(ColumnType.INTEGER, "numStepReconAcquisitionsFailed");
            table.addColumn(ColumnType.INTEGER, "numSixStacksCapped");
            return table;
        }
        return transaction.getTable("class_UploadedTeamInMatchData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_UploadedTeamInMatchData")) {
            Table table = transaction.getTable("class_UploadedTeamInMatchData");
            if(table.getColumnCount() != 25) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 25; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("stackedToteSet")) {
                throw new IllegalStateException("Missing column 'stackedToteSet'");
            }
            if (columnTypes.get("stackedToteSet") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'stackedToteSet'");
            }
            if (!columnTypes.containsKey("numContainersMovedIntoAutoZone")) {
                throw new IllegalStateException("Missing column 'numContainersMovedIntoAutoZone'");
            }
            if (columnTypes.get("numContainersMovedIntoAutoZone") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numContainersMovedIntoAutoZone'");
            }
            if (!columnTypes.containsKey("numTotesStacked")) {
                throw new IllegalStateException("Missing column 'numTotesStacked'");
            }
            if (columnTypes.get("numTotesStacked") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numTotesStacked'");
            }
            if (!columnTypes.containsKey("numReconLevels")) {
                throw new IllegalStateException("Missing column 'numReconLevels'");
            }
            if (columnTypes.get("numReconLevels") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numReconLevels'");
            }
            if (!columnTypes.containsKey("numNoodlesContributed")) {
                throw new IllegalStateException("Missing column 'numNoodlesContributed'");
            }
            if (columnTypes.get("numNoodlesContributed") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numNoodlesContributed'");
            }
            if (!columnTypes.containsKey("numReconsStacked")) {
                throw new IllegalStateException("Missing column 'numReconsStacked'");
            }
            if (columnTypes.get("numReconsStacked") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numReconsStacked'");
            }
            if (!columnTypes.containsKey("numHorizontalReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'numHorizontalReconsPickedUp'");
            }
            if (columnTypes.get("numHorizontalReconsPickedUp") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numHorizontalReconsPickedUp'");
            }
            if (!columnTypes.containsKey("numVerticalReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'numVerticalReconsPickedUp'");
            }
            if (columnTypes.get("numVerticalReconsPickedUp") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numVerticalReconsPickedUp'");
            }
            if (!columnTypes.containsKey("numTotesPickedUpFromGround")) {
                throw new IllegalStateException("Missing column 'numTotesPickedUpFromGround'");
            }
            if (columnTypes.get("numTotesPickedUpFromGround") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numTotesPickedUpFromGround'");
            }
            if (!columnTypes.containsKey("numLitterDropped")) {
                throw new IllegalStateException("Missing column 'numLitterDropped'");
            }
            if (columnTypes.get("numLitterDropped") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numLitterDropped'");
            }
            if (!columnTypes.containsKey("numStacksDamaged")) {
                throw new IllegalStateException("Missing column 'numStacksDamaged'");
            }
            if (columnTypes.get("numStacksDamaged") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numStacksDamaged'");
            }
            if(!columnTypes.containsKey("coopActions")) {
                throw new IllegalStateException("Missing column 'coopActions'");
            }
            if(columnTypes.get("coopActions") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'CoopAction' for column 'coopActions'");
            }
            if (!transaction.hasTable("class_CoopAction")) {
                throw new IllegalStateException("Missing table 'class_CoopAction' for column 'coopActions'");
            }
            if (!columnTypes.containsKey("maxFieldToteHeight")) {
                throw new IllegalStateException("Missing column 'maxFieldToteHeight'");
            }
            if (columnTypes.get("maxFieldToteHeight") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'maxFieldToteHeight'");
            }
            if (!columnTypes.containsKey("maxReconHeight")) {
                throw new IllegalStateException("Missing column 'maxReconHeight'");
            }
            if (columnTypes.get("maxReconHeight") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'maxReconHeight'");
            }
            if (!columnTypes.containsKey("numTeleopReconsFromStep")) {
                throw new IllegalStateException("Missing column 'numTeleopReconsFromStep'");
            }
            if (columnTypes.get("numTeleopReconsFromStep") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numTeleopReconsFromStep'");
            }
            if (!columnTypes.containsKey("numTotesFromHP")) {
                throw new IllegalStateException("Missing column 'numTotesFromHP'");
            }
            if (columnTypes.get("numTotesFromHP") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numTotesFromHP'");
            }
            if(!columnTypes.containsKey("reconAcquisitions")) {
                throw new IllegalStateException("Missing column 'reconAcquisitions'");
            }
            if(columnTypes.get("reconAcquisitions") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'ReconAcquisition' for column 'reconAcquisitions'");
            }
            if (!transaction.hasTable("class_ReconAcquisition")) {
                throw new IllegalStateException("Missing table 'class_ReconAcquisition' for column 'reconAcquisitions'");
            }
            if (!columnTypes.containsKey("agility")) {
                throw new IllegalStateException("Missing column 'agility'");
            }
            if (columnTypes.get("agility") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'agility'");
            }
            if (!columnTypes.containsKey("stackPlacing")) {
                throw new IllegalStateException("Missing column 'stackPlacing'");
            }
            if (columnTypes.get("stackPlacing") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'stackPlacing'");
            }
            if (!columnTypes.containsKey("humanPlayerLoading")) {
                throw new IllegalStateException("Missing column 'humanPlayerLoading'");
            }
            if (columnTypes.get("humanPlayerLoading") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'humanPlayerLoading'");
            }
            if (!columnTypes.containsKey("incapacitated")) {
                throw new IllegalStateException("Missing column 'incapacitated'");
            }
            if (columnTypes.get("incapacitated") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'incapacitated'");
            }
            if (!columnTypes.containsKey("disabled")) {
                throw new IllegalStateException("Missing column 'disabled'");
            }
            if (columnTypes.get("disabled") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'disabled'");
            }
            if (!columnTypes.containsKey("miscellaneousNotes")) {
                throw new IllegalStateException("Missing column 'miscellaneousNotes'");
            }
            if (columnTypes.get("miscellaneousNotes") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'miscellaneousNotes'");
            }
            if (!columnTypes.containsKey("numStepReconAcquisitionsFailed")) {
                throw new IllegalStateException("Missing column 'numStepReconAcquisitionsFailed'");
            }
            if (columnTypes.get("numStepReconAcquisitionsFailed") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numStepReconAcquisitionsFailed'");
            }
            if (!columnTypes.containsKey("numSixStacksCapped")) {
                throw new IllegalStateException("Missing column 'numSixStacksCapped'");
            }
            if (columnTypes.get("numSixStacksCapped") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'numSixStacksCapped'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("stackedToteSet", "numContainersMovedIntoAutoZone", "numTotesStacked", "numReconLevels", "numNoodlesContributed", "numReconsStacked", "numHorizontalReconsPickedUp", "numVerticalReconsPickedUp", "numTotesPickedUpFromGround", "numLitterDropped", "numStacksDamaged", "coopActions", "maxFieldToteHeight", "maxReconHeight", "numTeleopReconsFromStep", "numTotesFromHP", "reconAcquisitions", "agility", "stackPlacing", "humanPlayerLoading", "incapacitated", "disabled", "miscellaneousNotes", "numStepReconAcquisitionsFailed", "numSixStacksCapped");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("stackedToteSet")) {
            setStackedToteSet((boolean) json.getBoolean("stackedToteSet"));
        }
        if (json.has("numContainersMovedIntoAutoZone")) {
            setNumContainersMovedIntoAutoZone((int) json.getInt("numContainersMovedIntoAutoZone"));
        }
        if (json.has("numTotesStacked")) {
            setNumTotesStacked((int) json.getInt("numTotesStacked"));
        }
        if (json.has("numReconLevels")) {
            setNumReconLevels((int) json.getInt("numReconLevels"));
        }
        if (json.has("numNoodlesContributed")) {
            setNumNoodlesContributed((int) json.getInt("numNoodlesContributed"));
        }
        if (json.has("numReconsStacked")) {
            setNumReconsStacked((int) json.getInt("numReconsStacked"));
        }
        if (json.has("numHorizontalReconsPickedUp")) {
            setNumHorizontalReconsPickedUp((int) json.getInt("numHorizontalReconsPickedUp"));
        }
        if (json.has("numVerticalReconsPickedUp")) {
            setNumVerticalReconsPickedUp((int) json.getInt("numVerticalReconsPickedUp"));
        }
        if (json.has("numTotesPickedUpFromGround")) {
            setNumTotesPickedUpFromGround((int) json.getInt("numTotesPickedUpFromGround"));
        }
        if (json.has("numLitterDropped")) {
            setNumLitterDropped((int) json.getInt("numLitterDropped"));
        }
        if (json.has("numStacksDamaged")) {
            setNumStacksDamaged((int) json.getInt("numStacksDamaged"));
        }
        if (json.has("coopActions")) {
            JSONArray array = json.getJSONArray("coopActions");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.CoopAction obj = realm.createObject(org.citruscircuits.realm.CoopAction.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getCoopActions().add(obj);
            }
        }
        if (json.has("maxFieldToteHeight")) {
            setMaxFieldToteHeight((int) json.getInt("maxFieldToteHeight"));
        }
        if (json.has("maxReconHeight")) {
            setMaxReconHeight((int) json.getInt("maxReconHeight"));
        }
        if (json.has("numTeleopReconsFromStep")) {
            setNumTeleopReconsFromStep((int) json.getInt("numTeleopReconsFromStep"));
        }
        if (json.has("numTotesFromHP")) {
            setNumTotesFromHP((int) json.getInt("numTotesFromHP"));
        }
        if (json.has("reconAcquisitions")) {
            JSONArray array = json.getJSONArray("reconAcquisitions");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.ReconAcquisition obj = realm.createObject(org.citruscircuits.realm.ReconAcquisition.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getReconAcquisitions().add(obj);
            }
        }
        if (json.has("agility")) {
            setAgility((int) json.getInt("agility"));
        }
        if (json.has("stackPlacing")) {
            setStackPlacing((int) json.getInt("stackPlacing"));
        }
        if (json.has("humanPlayerLoading")) {
            setHumanPlayerLoading((int) json.getInt("humanPlayerLoading"));
        }
        if (json.has("incapacitated")) {
            setIncapacitated((boolean) json.getBoolean("incapacitated"));
        }
        if (json.has("disabled")) {
            setDisabled((boolean) json.getBoolean("disabled"));
        }
        if (json.has("miscellaneousNotes")) {
            setMiscellaneousNotes((String) json.getString("miscellaneousNotes"));
        }
        if (json.has("numStepReconAcquisitionsFailed")) {
            setNumStepReconAcquisitionsFailed((int) json.getInt("numStepReconAcquisitionsFailed"));
        }
        if (json.has("numSixStacksCapped")) {
            setNumSixStacksCapped((int) json.getInt("numSixStacksCapped"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("stackedToteSet") && reader.peek() != JsonToken.NULL) {
                setStackedToteSet((boolean) reader.nextBoolean());
            } else if (name.equals("numContainersMovedIntoAutoZone")  && reader.peek() != JsonToken.NULL) {
                setNumContainersMovedIntoAutoZone((int) reader.nextInt());
            } else if (name.equals("numTotesStacked")  && reader.peek() != JsonToken.NULL) {
                setNumTotesStacked((int) reader.nextInt());
            } else if (name.equals("numReconLevels")  && reader.peek() != JsonToken.NULL) {
                setNumReconLevels((int) reader.nextInt());
            } else if (name.equals("numNoodlesContributed")  && reader.peek() != JsonToken.NULL) {
                setNumNoodlesContributed((int) reader.nextInt());
            } else if (name.equals("numReconsStacked")  && reader.peek() != JsonToken.NULL) {
                setNumReconsStacked((int) reader.nextInt());
            } else if (name.equals("numHorizontalReconsPickedUp")  && reader.peek() != JsonToken.NULL) {
                setNumHorizontalReconsPickedUp((int) reader.nextInt());
            } else if (name.equals("numVerticalReconsPickedUp")  && reader.peek() != JsonToken.NULL) {
                setNumVerticalReconsPickedUp((int) reader.nextInt());
            } else if (name.equals("numTotesPickedUpFromGround")  && reader.peek() != JsonToken.NULL) {
                setNumTotesPickedUpFromGround((int) reader.nextInt());
            } else if (name.equals("numLitterDropped")  && reader.peek() != JsonToken.NULL) {
                setNumLitterDropped((int) reader.nextInt());
            } else if (name.equals("numStacksDamaged")  && reader.peek() != JsonToken.NULL) {
                setNumStacksDamaged((int) reader.nextInt());
            } else if (name.equals("coopActions")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.CoopAction obj = realm.createObject(org.citruscircuits.realm.CoopAction.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getCoopActions().add(obj);
                }
                reader.endArray();
            } else if (name.equals("maxFieldToteHeight")  && reader.peek() != JsonToken.NULL) {
                setMaxFieldToteHeight((int) reader.nextInt());
            } else if (name.equals("maxReconHeight")  && reader.peek() != JsonToken.NULL) {
                setMaxReconHeight((int) reader.nextInt());
            } else if (name.equals("numTeleopReconsFromStep")  && reader.peek() != JsonToken.NULL) {
                setNumTeleopReconsFromStep((int) reader.nextInt());
            } else if (name.equals("numTotesFromHP")  && reader.peek() != JsonToken.NULL) {
                setNumTotesFromHP((int) reader.nextInt());
            } else if (name.equals("reconAcquisitions")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.ReconAcquisition obj = realm.createObject(org.citruscircuits.realm.ReconAcquisition.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getReconAcquisitions().add(obj);
                }
                reader.endArray();
            } else if (name.equals("agility")  && reader.peek() != JsonToken.NULL) {
                setAgility((int) reader.nextInt());
            } else if (name.equals("stackPlacing")  && reader.peek() != JsonToken.NULL) {
                setStackPlacing((int) reader.nextInt());
            } else if (name.equals("humanPlayerLoading")  && reader.peek() != JsonToken.NULL) {
                setHumanPlayerLoading((int) reader.nextInt());
            } else if (name.equals("incapacitated")  && reader.peek() != JsonToken.NULL) {
                setIncapacitated((boolean) reader.nextBoolean());
            } else if (name.equals("disabled")  && reader.peek() != JsonToken.NULL) {
                setDisabled((boolean) reader.nextBoolean());
            } else if (name.equals("miscellaneousNotes")  && reader.peek() != JsonToken.NULL) {
                setMiscellaneousNotes((String) reader.nextString());
            } else if (name.equals("numStepReconAcquisitionsFailed")  && reader.peek() != JsonToken.NULL) {
                setNumStepReconAcquisitionsFailed((int) reader.nextInt());
            } else if (name.equals("numSixStacksCapped")  && reader.peek() != JsonToken.NULL) {
                setNumSixStacksCapped((int) reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UploadedTeamInMatchData = [");
        stringBuilder.append("{stackedToteSet:");
        stringBuilder.append(isStackedToteSet());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numContainersMovedIntoAutoZone:");
        stringBuilder.append(getNumContainersMovedIntoAutoZone());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numTotesStacked:");
        stringBuilder.append(getNumTotesStacked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numReconLevels:");
        stringBuilder.append(getNumReconLevels());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numNoodlesContributed:");
        stringBuilder.append(getNumNoodlesContributed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numReconsStacked:");
        stringBuilder.append(getNumReconsStacked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numHorizontalReconsPickedUp:");
        stringBuilder.append(getNumHorizontalReconsPickedUp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numVerticalReconsPickedUp:");
        stringBuilder.append(getNumVerticalReconsPickedUp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numTotesPickedUpFromGround:");
        stringBuilder.append(getNumTotesPickedUpFromGround());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numLitterDropped:");
        stringBuilder.append(getNumLitterDropped());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numStacksDamaged:");
        stringBuilder.append(getNumStacksDamaged());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coopActions:");
        stringBuilder.append("RealmList<CoopAction>[").append(getCoopActions().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxFieldToteHeight:");
        stringBuilder.append(getMaxFieldToteHeight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxReconHeight:");
        stringBuilder.append(getMaxReconHeight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numTeleopReconsFromStep:");
        stringBuilder.append(getNumTeleopReconsFromStep());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numTotesFromHP:");
        stringBuilder.append(getNumTotesFromHP());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reconAcquisitions:");
        stringBuilder.append("RealmList<ReconAcquisition>[").append(getReconAcquisitions().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{agility:");
        stringBuilder.append(getAgility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stackPlacing:");
        stringBuilder.append(getStackPlacing());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{humanPlayerLoading:");
        stringBuilder.append(getHumanPlayerLoading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{incapacitated:");
        stringBuilder.append(isIncapacitated());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{disabled:");
        stringBuilder.append(isDisabled());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{miscellaneousNotes:");
        stringBuilder.append(getMiscellaneousNotes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numStepReconAcquisitionsFailed:");
        stringBuilder.append(getNumStepReconAcquisitionsFailed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numSixStacksCapped:");
        stringBuilder.append(getNumSixStacksCapped());
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
        UploadedTeamInMatchDataRealmProxy aUploadedTeamInMatchData = (UploadedTeamInMatchDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aUploadedTeamInMatchData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aUploadedTeamInMatchData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aUploadedTeamInMatchData.row.getIndex()) return false;

        return true;
    }

}
