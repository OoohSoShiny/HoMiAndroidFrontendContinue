package homi.frontend.homiandroidfrontend;

import android.widget.Button;

import java.util.List;

import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.Models.AnimalSimpleModel;
import homi.frontend.homiandroidfrontend.Models.CheckupNoteModel;

public class Globals
{
    public static int Id;
    public static String DateFormat = "dd.MM.yyyy";
    public static List<AnimalNotesModel> GlobalAnimalNotes;
    public static List<CheckupNoteModel> GlobalCheckupNotes;
    public static List<AnimalSimpleModel> SimpleAnimalList;
    public static int FirstRowColor;
    public static int SecondRowColor;
}
