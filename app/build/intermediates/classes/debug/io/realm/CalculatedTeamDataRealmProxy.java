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

public class CalculatedTeamDataRealmProxy extends CalculatedTeamData {

    @Override
    public int getPredictedSeed() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedTeamData").get("predictedSeed"));
    }

    @Override
    public void setPredictedSeed(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedTeamData").get("predictedSeed"), (long) value);
    }

    @Override
    public int getTotalScore() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("CalculatedTeamData").get("totalScore"));
    }

    @Override
    public void setTotalScore(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("CalculatedTeamData").get("totalScore"), (long) value);
    }

    @Override
    public float getAverageScore() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("averageScore"));
    }

    @Override
    public void setAverageScore(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("averageScore"), (float) value);
    }

    @Override
    public float getPredictedTotalScore() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("predictedTotalScore"));
    }

    @Override
    public void setPredictedTotalScore(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("predictedTotalScore"), (float) value);
    }

    @Override
    public float getPredictedAverageScore() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("predictedAverageScore"));
    }

    @Override
    public void setPredictedAverageScore(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("predictedAverageScore"), (float) value);
    }

    @Override
    public float getFirstPickAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("firstPickAbility"));
    }

    @Override
    public void setFirstPickAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("firstPickAbility"), (float) value);
    }

    @Override
    public float getSecondPickAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("secondPickAbility"));
    }

    @Override
    public void setSecondPickAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("secondPickAbility"), (float) value);
    }

    @Override
    public float getThirdPickAbilityLandfill() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("thirdPickAbilityLandfill"));
    }

    @Override
    public void setThirdPickAbilityLandfill(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("thirdPickAbilityLandfill"), (float) value);
    }

    @Override
    public float getThirdPickAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("thirdPickAbility"));
    }

    @Override
    public void setThirdPickAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("thirdPickAbility"), (float) value);
    }

    @Override
    public float getStackingAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("stackingAbility"));
    }

    @Override
    public void setStackingAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("stackingAbility"), (float) value);
    }

    @Override
    public float getNoodleReliability() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("noodleReliability"));
    }

    @Override
    public void setNoodleReliability(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("noodleReliability"), (float) value);
    }

    @Override
    public float getAvgNumMaxHeightStacks() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumMaxHeightStacks"));
    }

    @Override
    public void setAvgNumMaxHeightStacks(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumMaxHeightStacks"), (float) value);
    }

    @Override
    public float getReconAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("reconAbility"));
    }

    @Override
    public void setReconAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("reconAbility"), (float) value);
    }

    @Override
    public float getReconReliability() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("reconReliability"));
    }

    @Override
    public void setReconReliability(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("reconReliability"), (float) value);
    }

    @Override
    public float getIsRobotMoveIntoAutoZonePercentage() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("isRobotMoveIntoAutoZonePercentage"));
    }

    @Override
    public void setIsRobotMoveIntoAutoZonePercentage(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("isRobotMoveIntoAutoZonePercentage"), (float) value);
    }

    @Override
    public float getIsStackedToteSetPercentage() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("isStackedToteSetPercentage"));
    }

    @Override
    public void setIsStackedToteSetPercentage(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("isStackedToteSetPercentage"), (float) value);
    }

    @Override
    public float getAvgNumReconsMovedIntoAutoZone() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsMovedIntoAutoZone"));
    }

    @Override
    public void setAvgNumReconsMovedIntoAutoZone(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsMovedIntoAutoZone"), (float) value);
    }

    @Override
    public float getAvgNumTotesStacked() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesStacked"));
    }

    @Override
    public void setAvgNumTotesStacked(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesStacked"), (float) value);
    }

    @Override
    public float getAvgNumReconLevels() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconLevels"));
    }

    @Override
    public void setAvgNumReconLevels(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconLevels"), (float) value);
    }

    @Override
    public float getAvgNumNoodlesContributed() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumNoodlesContributed"));
    }

    @Override
    public void setAvgNumNoodlesContributed(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumNoodlesContributed"), (float) value);
    }

    @Override
    public float getAvgNumReconsStacked() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsStacked"));
    }

    @Override
    public void setAvgNumReconsStacked(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsStacked"), (float) value);
    }

    @Override
    public float getAvgNumTotesPickedUpFromGround() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesPickedUpFromGround"));
    }

    @Override
    public void setAvgNumTotesPickedUpFromGround(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesPickedUpFromGround"), (float) value);
    }

    @Override
    public float getAvgNumLitterDropped() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumLitterDropped"));
    }

    @Override
    public void setAvgNumLitterDropped(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumLitterDropped"), (float) value);
    }

    @Override
    public float getAvgNumStacksDamaged() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumStacksDamaged"));
    }

    @Override
    public void setAvgNumStacksDamaged(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumStacksDamaged"), (float) value);
    }

    @Override
    public float getAvgMaxFieldToteHeight() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgMaxFieldToteHeight"));
    }

    @Override
    public void setAvgMaxFieldToteHeight(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgMaxFieldToteHeight"), (float) value);
    }

    @Override
    public float getAvgMaxReconHeight() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgMaxReconHeight"));
    }

    @Override
    public void setAvgMaxReconHeight(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgMaxReconHeight"), (float) value);
    }

    @Override
    public float getAvgAgility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgAgility"));
    }

    @Override
    public void setAvgAgility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgAgility"), (float) value);
    }

    @Override
    public float getDriverAbility() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("driverAbility"));
    }

    @Override
    public void setDriverAbility(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("driverAbility"), (float) value);
    }

    @Override
    public float getAvgStackPlacing() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgStackPlacing"));
    }

    @Override
    public void setAvgStackPlacing(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgStackPlacing"), (float) value);
    }

    @Override
    public float getAvgHumanPlayerLoading() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgHumanPlayerLoading"));
    }

    @Override
    public void setAvgHumanPlayerLoading(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgHumanPlayerLoading"), (float) value);
    }

    @Override
    public float getIncapacitatedPercentage() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("incapacitatedPercentage"));
    }

    @Override
    public void setIncapacitatedPercentage(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("incapacitatedPercentage"), (float) value);
    }

    @Override
    public float getDisabledPercentage() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("disabledPercentage"));
    }

    @Override
    public void setDisabledPercentage(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("disabledPercentage"), (float) value);
    }

    @Override
    public float getReliability() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("reliability"));
    }

    @Override
    public void setReliability(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("reliability"), (float) value);
    }

    @Override
    public String getReconAcquisitionTypes() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("CalculatedTeamData").get("reconAcquisitionTypes"));
    }

    @Override
    public void setReconAcquisitionTypes(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("CalculatedTeamData").get("reconAcquisitionTypes"), (String) value);
    }

    @Override
    public String getMostCommonReconAcquisitionType() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("CalculatedTeamData").get("mostCommonReconAcquisitionType"));
    }

    @Override
    public void setMostCommonReconAcquisitionType(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("CalculatedTeamData").get("mostCommonReconAcquisitionType"), (String) value);
    }

    @Override
    public float getAvgCoopPoints() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgCoopPoints"));
    }

    @Override
    public void setAvgCoopPoints(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgCoopPoints"), (float) value);
    }

    @Override
    public float getStepReconSuccessRateInAuto() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("stepReconSuccessRateInAuto"));
    }

    @Override
    public void setStepReconSuccessRateInAuto(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("stepReconSuccessRateInAuto"), (float) value);
    }

    @Override
    public float getAvgStepReconsAcquiredInAuto() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgStepReconsAcquiredInAuto"));
    }

    @Override
    public void setAvgStepReconsAcquiredInAuto(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgStepReconsAcquiredInAuto"), (float) value);
    }

    @Override
    public float getBottomPlacingSuccessRate() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("bottomPlacingSuccessRate"));
    }

    @Override
    public void setBottomPlacingSuccessRate(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("bottomPlacingSuccessRate"), (float) value);
    }

    @Override
    public float getAvgNumHorizontalReconsPickedUp() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumHorizontalReconsPickedUp"));
    }

    @Override
    public void setAvgNumHorizontalReconsPickedUp(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumHorizontalReconsPickedUp"), (float) value);
    }

    @Override
    public float getAvgNumVerticalReconsPickedUp() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumVerticalReconsPickedUp"));
    }

    @Override
    public void setAvgNumVerticalReconsPickedUp(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumVerticalReconsPickedUp"), (float) value);
    }

    @Override
    public float getAvgNumReconsPickedUp() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsPickedUp"));
    }

    @Override
    public void setAvgNumReconsPickedUp(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumReconsPickedUp"), (float) value);
    }

    @Override
    public float getAvgNumCappedSixStacks() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumCappedSixStacks"));
    }

    @Override
    public void setAvgNumCappedSixStacks(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumCappedSixStacks"), (float) value);
    }

    @Override
    public float getAvgNumTotesFromHP() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesFromHP"));
    }

    @Override
    public void setAvgNumTotesFromHP(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTotesFromHP"), (float) value);
    }

    @Override
    public float getAvgNumTeleopReconsFromStep() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTeleopReconsFromStep"));
    }

    @Override
    public void setAvgNumTeleopReconsFromStep(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("CalculatedTeamData").get("avgNumTeleopReconsFromStep"), (float) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_CalculatedTeamData")) {
            Table table = transaction.getTable("class_CalculatedTeamData");
            table.addColumn(ColumnType.INTEGER, "predictedSeed");
            table.addColumn(ColumnType.INTEGER, "totalScore");
            table.addColumn(ColumnType.FLOAT, "averageScore");
            table.addColumn(ColumnType.FLOAT, "predictedTotalScore");
            table.addColumn(ColumnType.FLOAT, "predictedAverageScore");
            table.addColumn(ColumnType.FLOAT, "firstPickAbility");
            table.addColumn(ColumnType.FLOAT, "secondPickAbility");
            table.addColumn(ColumnType.FLOAT, "thirdPickAbilityLandfill");
            table.addColumn(ColumnType.FLOAT, "thirdPickAbility");
            table.addColumn(ColumnType.FLOAT, "stackingAbility");
            table.addColumn(ColumnType.FLOAT, "noodleReliability");
            table.addColumn(ColumnType.FLOAT, "avgNumMaxHeightStacks");
            table.addColumn(ColumnType.FLOAT, "reconAbility");
            table.addColumn(ColumnType.FLOAT, "reconReliability");
            table.addColumn(ColumnType.FLOAT, "isRobotMoveIntoAutoZonePercentage");
            table.addColumn(ColumnType.FLOAT, "isStackedToteSetPercentage");
            table.addColumn(ColumnType.FLOAT, "avgNumReconsMovedIntoAutoZone");
            table.addColumn(ColumnType.FLOAT, "avgNumTotesStacked");
            table.addColumn(ColumnType.FLOAT, "avgNumReconLevels");
            table.addColumn(ColumnType.FLOAT, "avgNumNoodlesContributed");
            table.addColumn(ColumnType.FLOAT, "avgNumReconsStacked");
            table.addColumn(ColumnType.FLOAT, "avgNumTotesPickedUpFromGround");
            table.addColumn(ColumnType.FLOAT, "avgNumLitterDropped");
            table.addColumn(ColumnType.FLOAT, "avgNumStacksDamaged");
            table.addColumn(ColumnType.FLOAT, "avgMaxFieldToteHeight");
            table.addColumn(ColumnType.FLOAT, "avgMaxReconHeight");
            table.addColumn(ColumnType.FLOAT, "avgAgility");
            table.addColumn(ColumnType.FLOAT, "driverAbility");
            table.addColumn(ColumnType.FLOAT, "avgStackPlacing");
            table.addColumn(ColumnType.FLOAT, "avgHumanPlayerLoading");
            table.addColumn(ColumnType.FLOAT, "incapacitatedPercentage");
            table.addColumn(ColumnType.FLOAT, "disabledPercentage");
            table.addColumn(ColumnType.FLOAT, "reliability");
            table.addColumn(ColumnType.STRING, "reconAcquisitionTypes");
            table.addColumn(ColumnType.STRING, "mostCommonReconAcquisitionType");
            table.addColumn(ColumnType.FLOAT, "avgCoopPoints");
            table.addColumn(ColumnType.FLOAT, "stepReconSuccessRateInAuto");
            table.addColumn(ColumnType.FLOAT, "avgStepReconsAcquiredInAuto");
            table.addColumn(ColumnType.FLOAT, "bottomPlacingSuccessRate");
            table.addColumn(ColumnType.FLOAT, "avgNumHorizontalReconsPickedUp");
            table.addColumn(ColumnType.FLOAT, "avgNumVerticalReconsPickedUp");
            table.addColumn(ColumnType.FLOAT, "avgNumReconsPickedUp");
            table.addColumn(ColumnType.FLOAT, "avgNumCappedSixStacks");
            table.addColumn(ColumnType.FLOAT, "avgNumTotesFromHP");
            table.addColumn(ColumnType.FLOAT, "avgNumTeleopReconsFromStep");
            return table;
        }
        return transaction.getTable("class_CalculatedTeamData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_CalculatedTeamData")) {
            Table table = transaction.getTable("class_CalculatedTeamData");
            if(table.getColumnCount() != 45) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 45; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("predictedSeed")) {
                throw new IllegalStateException("Missing column 'predictedSeed'");
            }
            if (columnTypes.get("predictedSeed") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'predictedSeed'");
            }
            if (!columnTypes.containsKey("totalScore")) {
                throw new IllegalStateException("Missing column 'totalScore'");
            }
            if (columnTypes.get("totalScore") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'totalScore'");
            }
            if (!columnTypes.containsKey("averageScore")) {
                throw new IllegalStateException("Missing column 'averageScore'");
            }
            if (columnTypes.get("averageScore") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'averageScore'");
            }
            if (!columnTypes.containsKey("predictedTotalScore")) {
                throw new IllegalStateException("Missing column 'predictedTotalScore'");
            }
            if (columnTypes.get("predictedTotalScore") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'predictedTotalScore'");
            }
            if (!columnTypes.containsKey("predictedAverageScore")) {
                throw new IllegalStateException("Missing column 'predictedAverageScore'");
            }
            if (columnTypes.get("predictedAverageScore") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'predictedAverageScore'");
            }
            if (!columnTypes.containsKey("firstPickAbility")) {
                throw new IllegalStateException("Missing column 'firstPickAbility'");
            }
            if (columnTypes.get("firstPickAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'firstPickAbility'");
            }
            if (!columnTypes.containsKey("secondPickAbility")) {
                throw new IllegalStateException("Missing column 'secondPickAbility'");
            }
            if (columnTypes.get("secondPickAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'secondPickAbility'");
            }
            if (!columnTypes.containsKey("thirdPickAbilityLandfill")) {
                throw new IllegalStateException("Missing column 'thirdPickAbilityLandfill'");
            }
            if (columnTypes.get("thirdPickAbilityLandfill") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'thirdPickAbilityLandfill'");
            }
            if (!columnTypes.containsKey("thirdPickAbility")) {
                throw new IllegalStateException("Missing column 'thirdPickAbility'");
            }
            if (columnTypes.get("thirdPickAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'thirdPickAbility'");
            }
            if (!columnTypes.containsKey("stackingAbility")) {
                throw new IllegalStateException("Missing column 'stackingAbility'");
            }
            if (columnTypes.get("stackingAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'stackingAbility'");
            }
            if (!columnTypes.containsKey("noodleReliability")) {
                throw new IllegalStateException("Missing column 'noodleReliability'");
            }
            if (columnTypes.get("noodleReliability") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'noodleReliability'");
            }
            if (!columnTypes.containsKey("avgNumMaxHeightStacks")) {
                throw new IllegalStateException("Missing column 'avgNumMaxHeightStacks'");
            }
            if (columnTypes.get("avgNumMaxHeightStacks") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumMaxHeightStacks'");
            }
            if (!columnTypes.containsKey("reconAbility")) {
                throw new IllegalStateException("Missing column 'reconAbility'");
            }
            if (columnTypes.get("reconAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'reconAbility'");
            }
            if (!columnTypes.containsKey("reconReliability")) {
                throw new IllegalStateException("Missing column 'reconReliability'");
            }
            if (columnTypes.get("reconReliability") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'reconReliability'");
            }
            if (!columnTypes.containsKey("isRobotMoveIntoAutoZonePercentage")) {
                throw new IllegalStateException("Missing column 'isRobotMoveIntoAutoZonePercentage'");
            }
            if (columnTypes.get("isRobotMoveIntoAutoZonePercentage") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'isRobotMoveIntoAutoZonePercentage'");
            }
            if (!columnTypes.containsKey("isStackedToteSetPercentage")) {
                throw new IllegalStateException("Missing column 'isStackedToteSetPercentage'");
            }
            if (columnTypes.get("isStackedToteSetPercentage") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'isStackedToteSetPercentage'");
            }
            if (!columnTypes.containsKey("avgNumReconsMovedIntoAutoZone")) {
                throw new IllegalStateException("Missing column 'avgNumReconsMovedIntoAutoZone'");
            }
            if (columnTypes.get("avgNumReconsMovedIntoAutoZone") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumReconsMovedIntoAutoZone'");
            }
            if (!columnTypes.containsKey("avgNumTotesStacked")) {
                throw new IllegalStateException("Missing column 'avgNumTotesStacked'");
            }
            if (columnTypes.get("avgNumTotesStacked") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumTotesStacked'");
            }
            if (!columnTypes.containsKey("avgNumReconLevels")) {
                throw new IllegalStateException("Missing column 'avgNumReconLevels'");
            }
            if (columnTypes.get("avgNumReconLevels") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumReconLevels'");
            }
            if (!columnTypes.containsKey("avgNumNoodlesContributed")) {
                throw new IllegalStateException("Missing column 'avgNumNoodlesContributed'");
            }
            if (columnTypes.get("avgNumNoodlesContributed") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumNoodlesContributed'");
            }
            if (!columnTypes.containsKey("avgNumReconsStacked")) {
                throw new IllegalStateException("Missing column 'avgNumReconsStacked'");
            }
            if (columnTypes.get("avgNumReconsStacked") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumReconsStacked'");
            }
            if (!columnTypes.containsKey("avgNumTotesPickedUpFromGround")) {
                throw new IllegalStateException("Missing column 'avgNumTotesPickedUpFromGround'");
            }
            if (columnTypes.get("avgNumTotesPickedUpFromGround") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumTotesPickedUpFromGround'");
            }
            if (!columnTypes.containsKey("avgNumLitterDropped")) {
                throw new IllegalStateException("Missing column 'avgNumLitterDropped'");
            }
            if (columnTypes.get("avgNumLitterDropped") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumLitterDropped'");
            }
            if (!columnTypes.containsKey("avgNumStacksDamaged")) {
                throw new IllegalStateException("Missing column 'avgNumStacksDamaged'");
            }
            if (columnTypes.get("avgNumStacksDamaged") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumStacksDamaged'");
            }
            if (!columnTypes.containsKey("avgMaxFieldToteHeight")) {
                throw new IllegalStateException("Missing column 'avgMaxFieldToteHeight'");
            }
            if (columnTypes.get("avgMaxFieldToteHeight") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgMaxFieldToteHeight'");
            }
            if (!columnTypes.containsKey("avgMaxReconHeight")) {
                throw new IllegalStateException("Missing column 'avgMaxReconHeight'");
            }
            if (columnTypes.get("avgMaxReconHeight") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgMaxReconHeight'");
            }
            if (!columnTypes.containsKey("avgAgility")) {
                throw new IllegalStateException("Missing column 'avgAgility'");
            }
            if (columnTypes.get("avgAgility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgAgility'");
            }
            if (!columnTypes.containsKey("driverAbility")) {
                throw new IllegalStateException("Missing column 'driverAbility'");
            }
            if (columnTypes.get("driverAbility") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'driverAbility'");
            }
            if (!columnTypes.containsKey("avgStackPlacing")) {
                throw new IllegalStateException("Missing column 'avgStackPlacing'");
            }
            if (columnTypes.get("avgStackPlacing") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgStackPlacing'");
            }
            if (!columnTypes.containsKey("avgHumanPlayerLoading")) {
                throw new IllegalStateException("Missing column 'avgHumanPlayerLoading'");
            }
            if (columnTypes.get("avgHumanPlayerLoading") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgHumanPlayerLoading'");
            }
            if (!columnTypes.containsKey("incapacitatedPercentage")) {
                throw new IllegalStateException("Missing column 'incapacitatedPercentage'");
            }
            if (columnTypes.get("incapacitatedPercentage") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'incapacitatedPercentage'");
            }
            if (!columnTypes.containsKey("disabledPercentage")) {
                throw new IllegalStateException("Missing column 'disabledPercentage'");
            }
            if (columnTypes.get("disabledPercentage") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'disabledPercentage'");
            }
            if (!columnTypes.containsKey("reliability")) {
                throw new IllegalStateException("Missing column 'reliability'");
            }
            if (columnTypes.get("reliability") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'reliability'");
            }
            if (!columnTypes.containsKey("reconAcquisitionTypes")) {
                throw new IllegalStateException("Missing column 'reconAcquisitionTypes'");
            }
            if (columnTypes.get("reconAcquisitionTypes") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'reconAcquisitionTypes'");
            }
            if (!columnTypes.containsKey("mostCommonReconAcquisitionType")) {
                throw new IllegalStateException("Missing column 'mostCommonReconAcquisitionType'");
            }
            if (columnTypes.get("mostCommonReconAcquisitionType") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'mostCommonReconAcquisitionType'");
            }
            if (!columnTypes.containsKey("avgCoopPoints")) {
                throw new IllegalStateException("Missing column 'avgCoopPoints'");
            }
            if (columnTypes.get("avgCoopPoints") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgCoopPoints'");
            }
            if (!columnTypes.containsKey("stepReconSuccessRateInAuto")) {
                throw new IllegalStateException("Missing column 'stepReconSuccessRateInAuto'");
            }
            if (columnTypes.get("stepReconSuccessRateInAuto") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'stepReconSuccessRateInAuto'");
            }
            if (!columnTypes.containsKey("avgStepReconsAcquiredInAuto")) {
                throw new IllegalStateException("Missing column 'avgStepReconsAcquiredInAuto'");
            }
            if (columnTypes.get("avgStepReconsAcquiredInAuto") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgStepReconsAcquiredInAuto'");
            }
            if (!columnTypes.containsKey("bottomPlacingSuccessRate")) {
                throw new IllegalStateException("Missing column 'bottomPlacingSuccessRate'");
            }
            if (columnTypes.get("bottomPlacingSuccessRate") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'bottomPlacingSuccessRate'");
            }
            if (!columnTypes.containsKey("avgNumHorizontalReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'avgNumHorizontalReconsPickedUp'");
            }
            if (columnTypes.get("avgNumHorizontalReconsPickedUp") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumHorizontalReconsPickedUp'");
            }
            if (!columnTypes.containsKey("avgNumVerticalReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'avgNumVerticalReconsPickedUp'");
            }
            if (columnTypes.get("avgNumVerticalReconsPickedUp") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumVerticalReconsPickedUp'");
            }
            if (!columnTypes.containsKey("avgNumReconsPickedUp")) {
                throw new IllegalStateException("Missing column 'avgNumReconsPickedUp'");
            }
            if (columnTypes.get("avgNumReconsPickedUp") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumReconsPickedUp'");
            }
            if (!columnTypes.containsKey("avgNumCappedSixStacks")) {
                throw new IllegalStateException("Missing column 'avgNumCappedSixStacks'");
            }
            if (columnTypes.get("avgNumCappedSixStacks") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumCappedSixStacks'");
            }
            if (!columnTypes.containsKey("avgNumTotesFromHP")) {
                throw new IllegalStateException("Missing column 'avgNumTotesFromHP'");
            }
            if (columnTypes.get("avgNumTotesFromHP") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumTotesFromHP'");
            }
            if (!columnTypes.containsKey("avgNumTeleopReconsFromStep")) {
                throw new IllegalStateException("Missing column 'avgNumTeleopReconsFromStep'");
            }
            if (columnTypes.get("avgNumTeleopReconsFromStep") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'avgNumTeleopReconsFromStep'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("predictedSeed", "totalScore", "averageScore", "predictedTotalScore", "predictedAverageScore", "firstPickAbility", "secondPickAbility", "thirdPickAbilityLandfill", "thirdPickAbility", "stackingAbility", "noodleReliability", "avgNumMaxHeightStacks", "reconAbility", "reconReliability", "isRobotMoveIntoAutoZonePercentage", "isStackedToteSetPercentage", "avgNumReconsMovedIntoAutoZone", "avgNumTotesStacked", "avgNumReconLevels", "avgNumNoodlesContributed", "avgNumReconsStacked", "avgNumTotesPickedUpFromGround", "avgNumLitterDropped", "avgNumStacksDamaged", "avgMaxFieldToteHeight", "avgMaxReconHeight", "avgAgility", "driverAbility", "avgStackPlacing", "avgHumanPlayerLoading", "incapacitatedPercentage", "disabledPercentage", "reliability", "reconAcquisitionTypes", "mostCommonReconAcquisitionType", "avgCoopPoints", "stepReconSuccessRateInAuto", "avgStepReconsAcquiredInAuto", "bottomPlacingSuccessRate", "avgNumHorizontalReconsPickedUp", "avgNumVerticalReconsPickedUp", "avgNumReconsPickedUp", "avgNumCappedSixStacks", "avgNumTotesFromHP", "avgNumTeleopReconsFromStep");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("predictedSeed")) {
            setPredictedSeed((int) json.getInt("predictedSeed"));
        }
        if (json.has("totalScore")) {
            setTotalScore((int) json.getInt("totalScore"));
        }
        if (json.has("averageScore")) {
            setAverageScore((float) json.getDouble("averageScore"));
        }
        if (json.has("predictedTotalScore")) {
            setPredictedTotalScore((float) json.getDouble("predictedTotalScore"));
        }
        if (json.has("predictedAverageScore")) {
            setPredictedAverageScore((float) json.getDouble("predictedAverageScore"));
        }
        if (json.has("firstPickAbility")) {
            setFirstPickAbility((float) json.getDouble("firstPickAbility"));
        }
        if (json.has("secondPickAbility")) {
            setSecondPickAbility((float) json.getDouble("secondPickAbility"));
        }
        if (json.has("thirdPickAbilityLandfill")) {
            setThirdPickAbilityLandfill((float) json.getDouble("thirdPickAbilityLandfill"));
        }
        if (json.has("thirdPickAbility")) {
            setThirdPickAbility((float) json.getDouble("thirdPickAbility"));
        }
        if (json.has("stackingAbility")) {
            setStackingAbility((float) json.getDouble("stackingAbility"));
        }
        if (json.has("noodleReliability")) {
            setNoodleReliability((float) json.getDouble("noodleReliability"));
        }
        if (json.has("avgNumMaxHeightStacks")) {
            setAvgNumMaxHeightStacks((float) json.getDouble("avgNumMaxHeightStacks"));
        }
        if (json.has("reconAbility")) {
            setReconAbility((float) json.getDouble("reconAbility"));
        }
        if (json.has("reconReliability")) {
            setReconReliability((float) json.getDouble("reconReliability"));
        }
        if (json.has("isRobotMoveIntoAutoZonePercentage")) {
            setIsRobotMoveIntoAutoZonePercentage((float) json.getDouble("isRobotMoveIntoAutoZonePercentage"));
        }
        if (json.has("isStackedToteSetPercentage")) {
            setIsStackedToteSetPercentage((float) json.getDouble("isStackedToteSetPercentage"));
        }
        if (json.has("avgNumReconsMovedIntoAutoZone")) {
            setAvgNumReconsMovedIntoAutoZone((float) json.getDouble("avgNumReconsMovedIntoAutoZone"));
        }
        if (json.has("avgNumTotesStacked")) {
            setAvgNumTotesStacked((float) json.getDouble("avgNumTotesStacked"));
        }
        if (json.has("avgNumReconLevels")) {
            setAvgNumReconLevels((float) json.getDouble("avgNumReconLevels"));
        }
        if (json.has("avgNumNoodlesContributed")) {
            setAvgNumNoodlesContributed((float) json.getDouble("avgNumNoodlesContributed"));
        }
        if (json.has("avgNumReconsStacked")) {
            setAvgNumReconsStacked((float) json.getDouble("avgNumReconsStacked"));
        }
        if (json.has("avgNumTotesPickedUpFromGround")) {
            setAvgNumTotesPickedUpFromGround((float) json.getDouble("avgNumTotesPickedUpFromGround"));
        }
        if (json.has("avgNumLitterDropped")) {
            setAvgNumLitterDropped((float) json.getDouble("avgNumLitterDropped"));
        }
        if (json.has("avgNumStacksDamaged")) {
            setAvgNumStacksDamaged((float) json.getDouble("avgNumStacksDamaged"));
        }
        if (json.has("avgMaxFieldToteHeight")) {
            setAvgMaxFieldToteHeight((float) json.getDouble("avgMaxFieldToteHeight"));
        }
        if (json.has("avgMaxReconHeight")) {
            setAvgMaxReconHeight((float) json.getDouble("avgMaxReconHeight"));
        }
        if (json.has("avgAgility")) {
            setAvgAgility((float) json.getDouble("avgAgility"));
        }
        if (json.has("driverAbility")) {
            setDriverAbility((float) json.getDouble("driverAbility"));
        }
        if (json.has("avgStackPlacing")) {
            setAvgStackPlacing((float) json.getDouble("avgStackPlacing"));
        }
        if (json.has("avgHumanPlayerLoading")) {
            setAvgHumanPlayerLoading((float) json.getDouble("avgHumanPlayerLoading"));
        }
        if (json.has("incapacitatedPercentage")) {
            setIncapacitatedPercentage((float) json.getDouble("incapacitatedPercentage"));
        }
        if (json.has("disabledPercentage")) {
            setDisabledPercentage((float) json.getDouble("disabledPercentage"));
        }
        if (json.has("reliability")) {
            setReliability((float) json.getDouble("reliability"));
        }
        if (json.has("reconAcquisitionTypes")) {
            setReconAcquisitionTypes((String) json.getString("reconAcquisitionTypes"));
        }
        if (json.has("mostCommonReconAcquisitionType")) {
            setMostCommonReconAcquisitionType((String) json.getString("mostCommonReconAcquisitionType"));
        }
        if (json.has("avgCoopPoints")) {
            setAvgCoopPoints((float) json.getDouble("avgCoopPoints"));
        }
        if (json.has("stepReconSuccessRateInAuto")) {
            setStepReconSuccessRateInAuto((float) json.getDouble("stepReconSuccessRateInAuto"));
        }
        if (json.has("avgStepReconsAcquiredInAuto")) {
            setAvgStepReconsAcquiredInAuto((float) json.getDouble("avgStepReconsAcquiredInAuto"));
        }
        if (json.has("bottomPlacingSuccessRate")) {
            setBottomPlacingSuccessRate((float) json.getDouble("bottomPlacingSuccessRate"));
        }
        if (json.has("avgNumHorizontalReconsPickedUp")) {
            setAvgNumHorizontalReconsPickedUp((float) json.getDouble("avgNumHorizontalReconsPickedUp"));
        }
        if (json.has("avgNumVerticalReconsPickedUp")) {
            setAvgNumVerticalReconsPickedUp((float) json.getDouble("avgNumVerticalReconsPickedUp"));
        }
        if (json.has("avgNumReconsPickedUp")) {
            setAvgNumReconsPickedUp((float) json.getDouble("avgNumReconsPickedUp"));
        }
        if (json.has("avgNumCappedSixStacks")) {
            setAvgNumCappedSixStacks((float) json.getDouble("avgNumCappedSixStacks"));
        }
        if (json.has("avgNumTotesFromHP")) {
            setAvgNumTotesFromHP((float) json.getDouble("avgNumTotesFromHP"));
        }
        if (json.has("avgNumTeleopReconsFromStep")) {
            setAvgNumTeleopReconsFromStep((float) json.getDouble("avgNumTeleopReconsFromStep"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("predictedSeed") && reader.peek() != JsonToken.NULL) {
                setPredictedSeed((int) reader.nextInt());
            } else if (name.equals("totalScore")  && reader.peek() != JsonToken.NULL) {
                setTotalScore((int) reader.nextInt());
            } else if (name.equals("averageScore")  && reader.peek() != JsonToken.NULL) {
                setAverageScore((float) reader.nextDouble());
            } else if (name.equals("predictedTotalScore")  && reader.peek() != JsonToken.NULL) {
                setPredictedTotalScore((float) reader.nextDouble());
            } else if (name.equals("predictedAverageScore")  && reader.peek() != JsonToken.NULL) {
                setPredictedAverageScore((float) reader.nextDouble());
            } else if (name.equals("firstPickAbility")  && reader.peek() != JsonToken.NULL) {
                setFirstPickAbility((float) reader.nextDouble());
            } else if (name.equals("secondPickAbility")  && reader.peek() != JsonToken.NULL) {
                setSecondPickAbility((float) reader.nextDouble());
            } else if (name.equals("thirdPickAbilityLandfill")  && reader.peek() != JsonToken.NULL) {
                setThirdPickAbilityLandfill((float) reader.nextDouble());
            } else if (name.equals("thirdPickAbility")  && reader.peek() != JsonToken.NULL) {
                setThirdPickAbility((float) reader.nextDouble());
            } else if (name.equals("stackingAbility")  && reader.peek() != JsonToken.NULL) {
                setStackingAbility((float) reader.nextDouble());
            } else if (name.equals("noodleReliability")  && reader.peek() != JsonToken.NULL) {
                setNoodleReliability((float) reader.nextDouble());
            } else if (name.equals("avgNumMaxHeightStacks")  && reader.peek() != JsonToken.NULL) {
                setAvgNumMaxHeightStacks((float) reader.nextDouble());
            } else if (name.equals("reconAbility")  && reader.peek() != JsonToken.NULL) {
                setReconAbility((float) reader.nextDouble());
            } else if (name.equals("reconReliability")  && reader.peek() != JsonToken.NULL) {
                setReconReliability((float) reader.nextDouble());
            } else if (name.equals("isRobotMoveIntoAutoZonePercentage")  && reader.peek() != JsonToken.NULL) {
                setIsRobotMoveIntoAutoZonePercentage((float) reader.nextDouble());
            } else if (name.equals("isStackedToteSetPercentage")  && reader.peek() != JsonToken.NULL) {
                setIsStackedToteSetPercentage((float) reader.nextDouble());
            } else if (name.equals("avgNumReconsMovedIntoAutoZone")  && reader.peek() != JsonToken.NULL) {
                setAvgNumReconsMovedIntoAutoZone((float) reader.nextDouble());
            } else if (name.equals("avgNumTotesStacked")  && reader.peek() != JsonToken.NULL) {
                setAvgNumTotesStacked((float) reader.nextDouble());
            } else if (name.equals("avgNumReconLevels")  && reader.peek() != JsonToken.NULL) {
                setAvgNumReconLevels((float) reader.nextDouble());
            } else if (name.equals("avgNumNoodlesContributed")  && reader.peek() != JsonToken.NULL) {
                setAvgNumNoodlesContributed((float) reader.nextDouble());
            } else if (name.equals("avgNumReconsStacked")  && reader.peek() != JsonToken.NULL) {
                setAvgNumReconsStacked((float) reader.nextDouble());
            } else if (name.equals("avgNumTotesPickedUpFromGround")  && reader.peek() != JsonToken.NULL) {
                setAvgNumTotesPickedUpFromGround((float) reader.nextDouble());
            } else if (name.equals("avgNumLitterDropped")  && reader.peek() != JsonToken.NULL) {
                setAvgNumLitterDropped((float) reader.nextDouble());
            } else if (name.equals("avgNumStacksDamaged")  && reader.peek() != JsonToken.NULL) {
                setAvgNumStacksDamaged((float) reader.nextDouble());
            } else if (name.equals("avgMaxFieldToteHeight")  && reader.peek() != JsonToken.NULL) {
                setAvgMaxFieldToteHeight((float) reader.nextDouble());
            } else if (name.equals("avgMaxReconHeight")  && reader.peek() != JsonToken.NULL) {
                setAvgMaxReconHeight((float) reader.nextDouble());
            } else if (name.equals("avgAgility")  && reader.peek() != JsonToken.NULL) {
                setAvgAgility((float) reader.nextDouble());
            } else if (name.equals("driverAbility")  && reader.peek() != JsonToken.NULL) {
                setDriverAbility((float) reader.nextDouble());
            } else if (name.equals("avgStackPlacing")  && reader.peek() != JsonToken.NULL) {
                setAvgStackPlacing((float) reader.nextDouble());
            } else if (name.equals("avgHumanPlayerLoading")  && reader.peek() != JsonToken.NULL) {
                setAvgHumanPlayerLoading((float) reader.nextDouble());
            } else if (name.equals("incapacitatedPercentage")  && reader.peek() != JsonToken.NULL) {
                setIncapacitatedPercentage((float) reader.nextDouble());
            } else if (name.equals("disabledPercentage")  && reader.peek() != JsonToken.NULL) {
                setDisabledPercentage((float) reader.nextDouble());
            } else if (name.equals("reliability")  && reader.peek() != JsonToken.NULL) {
                setReliability((float) reader.nextDouble());
            } else if (name.equals("reconAcquisitionTypes")  && reader.peek() != JsonToken.NULL) {
                setReconAcquisitionTypes((String) reader.nextString());
            } else if (name.equals("mostCommonReconAcquisitionType")  && reader.peek() != JsonToken.NULL) {
                setMostCommonReconAcquisitionType((String) reader.nextString());
            } else if (name.equals("avgCoopPoints")  && reader.peek() != JsonToken.NULL) {
                setAvgCoopPoints((float) reader.nextDouble());
            } else if (name.equals("stepReconSuccessRateInAuto")  && reader.peek() != JsonToken.NULL) {
                setStepReconSuccessRateInAuto((float) reader.nextDouble());
            } else if (name.equals("avgStepReconsAcquiredInAuto")  && reader.peek() != JsonToken.NULL) {
                setAvgStepReconsAcquiredInAuto((float) reader.nextDouble());
            } else if (name.equals("bottomPlacingSuccessRate")  && reader.peek() != JsonToken.NULL) {
                setBottomPlacingSuccessRate((float) reader.nextDouble());
            } else if (name.equals("avgNumHorizontalReconsPickedUp")  && reader.peek() != JsonToken.NULL) {
                setAvgNumHorizontalReconsPickedUp((float) reader.nextDouble());
            } else if (name.equals("avgNumVerticalReconsPickedUp")  && reader.peek() != JsonToken.NULL) {
                setAvgNumVerticalReconsPickedUp((float) reader.nextDouble());
            } else if (name.equals("avgNumReconsPickedUp")  && reader.peek() != JsonToken.NULL) {
                setAvgNumReconsPickedUp((float) reader.nextDouble());
            } else if (name.equals("avgNumCappedSixStacks")  && reader.peek() != JsonToken.NULL) {
                setAvgNumCappedSixStacks((float) reader.nextDouble());
            } else if (name.equals("avgNumTotesFromHP")  && reader.peek() != JsonToken.NULL) {
                setAvgNumTotesFromHP((float) reader.nextDouble());
            } else if (name.equals("avgNumTeleopReconsFromStep")  && reader.peek() != JsonToken.NULL) {
                setAvgNumTeleopReconsFromStep((float) reader.nextDouble());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CalculatedTeamData = [");
        stringBuilder.append("{predictedSeed:");
        stringBuilder.append(getPredictedSeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalScore:");
        stringBuilder.append(getTotalScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{averageScore:");
        stringBuilder.append(getAverageScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{predictedTotalScore:");
        stringBuilder.append(getPredictedTotalScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{predictedAverageScore:");
        stringBuilder.append(getPredictedAverageScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstPickAbility:");
        stringBuilder.append(getFirstPickAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{secondPickAbility:");
        stringBuilder.append(getSecondPickAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thirdPickAbilityLandfill:");
        stringBuilder.append(getThirdPickAbilityLandfill());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thirdPickAbility:");
        stringBuilder.append(getThirdPickAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stackingAbility:");
        stringBuilder.append(getStackingAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{noodleReliability:");
        stringBuilder.append(getNoodleReliability());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumMaxHeightStacks:");
        stringBuilder.append(getAvgNumMaxHeightStacks());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reconAbility:");
        stringBuilder.append(getReconAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reconReliability:");
        stringBuilder.append(getReconReliability());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isRobotMoveIntoAutoZonePercentage:");
        stringBuilder.append(getIsRobotMoveIntoAutoZonePercentage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isStackedToteSetPercentage:");
        stringBuilder.append(getIsStackedToteSetPercentage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumReconsMovedIntoAutoZone:");
        stringBuilder.append(getAvgNumReconsMovedIntoAutoZone());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumTotesStacked:");
        stringBuilder.append(getAvgNumTotesStacked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumReconLevels:");
        stringBuilder.append(getAvgNumReconLevels());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumNoodlesContributed:");
        stringBuilder.append(getAvgNumNoodlesContributed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumReconsStacked:");
        stringBuilder.append(getAvgNumReconsStacked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumTotesPickedUpFromGround:");
        stringBuilder.append(getAvgNumTotesPickedUpFromGround());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumLitterDropped:");
        stringBuilder.append(getAvgNumLitterDropped());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumStacksDamaged:");
        stringBuilder.append(getAvgNumStacksDamaged());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgMaxFieldToteHeight:");
        stringBuilder.append(getAvgMaxFieldToteHeight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgMaxReconHeight:");
        stringBuilder.append(getAvgMaxReconHeight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgAgility:");
        stringBuilder.append(getAvgAgility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{driverAbility:");
        stringBuilder.append(getDriverAbility());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgStackPlacing:");
        stringBuilder.append(getAvgStackPlacing());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgHumanPlayerLoading:");
        stringBuilder.append(getAvgHumanPlayerLoading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{incapacitatedPercentage:");
        stringBuilder.append(getIncapacitatedPercentage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{disabledPercentage:");
        stringBuilder.append(getDisabledPercentage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reliability:");
        stringBuilder.append(getReliability());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reconAcquisitionTypes:");
        stringBuilder.append(getReconAcquisitionTypes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mostCommonReconAcquisitionType:");
        stringBuilder.append(getMostCommonReconAcquisitionType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgCoopPoints:");
        stringBuilder.append(getAvgCoopPoints());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stepReconSuccessRateInAuto:");
        stringBuilder.append(getStepReconSuccessRateInAuto());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgStepReconsAcquiredInAuto:");
        stringBuilder.append(getAvgStepReconsAcquiredInAuto());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bottomPlacingSuccessRate:");
        stringBuilder.append(getBottomPlacingSuccessRate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumHorizontalReconsPickedUp:");
        stringBuilder.append(getAvgNumHorizontalReconsPickedUp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumVerticalReconsPickedUp:");
        stringBuilder.append(getAvgNumVerticalReconsPickedUp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumReconsPickedUp:");
        stringBuilder.append(getAvgNumReconsPickedUp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumCappedSixStacks:");
        stringBuilder.append(getAvgNumCappedSixStacks());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumTotesFromHP:");
        stringBuilder.append(getAvgNumTotesFromHP());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{avgNumTeleopReconsFromStep:");
        stringBuilder.append(getAvgNumTeleopReconsFromStep());
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
        CalculatedTeamDataRealmProxy aCalculatedTeamData = (CalculatedTeamDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCalculatedTeamData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCalculatedTeamData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCalculatedTeamData.row.getIndex()) return false;

        return true;
    }

}
