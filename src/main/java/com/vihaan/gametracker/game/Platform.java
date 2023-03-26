package com.vihaan.gametracker.game;

public enum Platform {
        PSX("PlayStation"),
        PS2("PlayStation 2"),
        PS3("PlayStation 3"),
        PS4("PlayStation 4"),
        PS5("PlayStation 5"),
        PSP("PlayStation Portable"),
        XBOX("XBOX"),
        X360("XBOX 360"),
        XONE("XBOX ONE"),
        XSERIES("XBOB SERIES"),
        NSWITCH("Nintendo Switch"),
        WII("Nintendo Wii"),
        GBC("GameBoy Color"),
        GBA("GameBoy Advance"),
        PC("PC");

        private String platformName;

        Platform(String platformName) {
                this.platformName = platformName;
        }

        @Override
        public String toString() {
                return platformName;
        }
}
