package homi.frontend.homiandroidfrontend.Models;
import java.util.List;

public class CompleteSingleAnimalModel extends AnimalModel
{
    public String vatertier;
    public String muttertier;
    public List<AnimalNotesModel> allgNotizen;
    public List<CheckupNoteModel> tuNotizen;
    public List<PastureModel> weidegruppen;
    public String ordnungsgruppe;
}
