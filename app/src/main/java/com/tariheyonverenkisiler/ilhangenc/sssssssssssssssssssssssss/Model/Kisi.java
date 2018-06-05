package com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss.Model;


   //her kişi bilgilerinin elde edilidği class

    public class Kisi {

        private String kisiId;
        private String kisiAdi;
        private String kisiHayat;
        private String kisiResim;


        public Kisi(){

        }


        public Kisi(String kisiId, String kisiAdi, String kisiHayat, String kisiResim) {
            this.kisiId = kisiId;
            this.kisiAdi = kisiAdi;
            this.kisiHayat = kisiHayat;
            this.kisiResim = kisiResim;
        }

        public String getKisiId() {
            return kisiId;
        }

        public void setKisiId(String kisiId) {
            this.kisiId = kisiId;
        }

        public String getKisiAdi() {
            return kisiAdi;
        }

        public void setKisiAdi(String kisiAdi) {
            this.kisiAdi = kisiAdi;
        }

        public String getKisiHayat() {
            return kisiHayat;
        }

        public void setKisiHayat(String kisiHayat) {
            this.kisiHayat = kisiHayat;
        }

        public String getKisiResim() {
            return kisiResim;
        }

        public void setKisiResim(String kisiResim) {
            this.kisiResim = kisiResim;
        }



    }