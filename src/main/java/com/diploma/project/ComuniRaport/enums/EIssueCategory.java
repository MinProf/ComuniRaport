package com.diploma.project.ComuniRaport.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EIssueCategory {
    DRUM_BLOCAT("Drum blocat"),
    MASINA_ABANDONATA("Mașină abandonată"),
    GROAPA_PE_CAROSABIL("Groapă pe carosabil"),
    ILUMINAT_STRADAL_DEFECT("Iluminat stradal defect"),
    STALP_ELECTRICITATE_CAZUT("Stâlp de electricitate căzut"),
    TROTUAR_DETERIORAT("Trotuar deteriorat"),
    PARCURI_NEGLIJATE("Parcuri neglijate"),
    VANDALISM_GRAFFITI("Vandalism și graffiti"),
    PROBLEME_APA_CANALIZARE("Probleme cu gestionarea apei și canalizării"),
    PARCARE_NEREGULAMENTARA("Parcare neregulamentară"),
    GUNOI_ARUNCAT("Gunoi aruncat pe domeniul public"),
    ANIMAL_ABANDONAT("Animal abandonat în spațiul public"),
    NERESPECTARE_REGULI_ZGOMOT("Nerespectarea regulilor de zgomot"),
    SEMNALIZARE_RUTIERA_DEFECTA("Semnalizare rutieră defectă"),
    PROBLEME_COLECTARE_DESEURI("Probleme de colectare a deșeurilor");

    @Getter
    private final String displayName;
}
