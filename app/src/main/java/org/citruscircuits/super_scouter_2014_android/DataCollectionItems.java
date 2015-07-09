package org.citruscircuits.super_scouter_2014_android;

public class DataCollectionItems
{
	// An array of small arrays
	// Each small array has n strings:
	// Index 0: Unique key
	// Index 1: Type ("integer", "boolean")
	// Index [2,n): Arbitrary parameters specific to the type

	// @formatter:off
	public static String[][] items = {
        { "incapacitated", "Toggle", "Functional", "Incapacitated"},
        { "disabled", "Toggle", "Enabled", "Disabled"},
        //{ "humanPlayerLoading", "Stepper", "HP Loading", "0", "3"},
        { "stackPlacing", "Stepper", "Stack Security", "0", "3" },
        { "agility", "Stepper", "Agility", "0", "3" },
        //{ "numReconsPickedUp", "Stepper", "Recons Collected", "0", "7" },
            //{ "missing", "Toggle", "Present", "Missing"}
	};
	// @formatter:on
}
