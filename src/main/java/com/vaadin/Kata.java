package com.vaadin;

import com.sun.org.apache.xpath.internal.operations.Plus;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Random;

public class Kata extends VerticalLayout {
    public Kata() {
        buildButton();

    }

    int cikartmatoplam = 0;
    int toplam = 0;
    int carp = 1;
    int bol = 0;

    private void buildButton() {
        Button[][] dizi = new Button[5][5];
        boolean sutunMu = true;
        int valueBtn;

        for (int i = 0; i < 5; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            for (int j = 0; j < 5; j++) {
                int finalI = i;
                int finalJ = j;

                MyButton button = new MyButton();
                dizi[i][j] = button;
                getRandom();
                if (dizi[i][j] == dizi[0][0]) {
                    button.setIcon(FontAwesome.CIRCLE);
                }
                else if (dizi[i][j] == dizi[0][1]) {

                    button.setIcon(FontAwesome.PLUS);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int altindex = finalI;
                            toplam=0;
                            for (int k = 1; k < 5; k++) {
                                altindex += 1;
                                Button buttonAlti = dizi[altindex][finalJ];
                                toplam += (Integer) buttonAlti.getData();
                                Notification.show("toplam" + toplam);

                            }
                        }
                    });

                }
                else if (dizi[i][j] == dizi[1][0]) {

                    button.setIcon(FontAwesome.PLUS);
                    button.sutunMu = false;
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int yanindex = finalJ;
                            toplam=0;
                            for (int k = 1; k < 5; k++) {
                                yanindex += 1;
                                Button buttonAlti = dizi[finalI][yanindex];
                                toplam += (Integer) buttonAlti.getData();
                                Notification.show("Satır  Toplam" + toplam);
                            }
                        }
                    });
                }
                else if (dizi[i][j] == dizi[0][2]) {
                    button.setIcon(FontAwesome.MINUS);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int altindex = finalI;
                            cikartmatoplam=0;
                            for (int k = 1; k < 5; k++) {
                                altindex += 1;
                                Button buttonAlti = dizi[altindex][finalJ];
                                cikartmatoplam -= (Integer) buttonAlti.getData();
                                Notification.show("Çıkarma" + cikartmatoplam);
                            }
                        }
                    });
                }
                else if (dizi[i][j] == dizi[2][0]) {

                    button.setIcon(FontAwesome.MINUS);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {

                            int yanindex = finalJ;
                            cikartmatoplam = 0;
                            for (int k = 1; k < 5; k++) {
                                yanindex += 1;
                                Button buttonAlti = dizi[finalI][yanindex];
                                cikartmatoplam -= (Integer) buttonAlti.getData();
                                Notification.show("Satır  Fark" + cikartmatoplam);
                            }
                        }
                    });
                }
                else if (dizi[i][j] == dizi[0][3]) {

                    button.setIcon(FontAwesome.TIMES);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int altindex = finalI;
                            carp=1;
                            for (int k = 1; k < 5; k++) {
                                altindex += 1;
                                Button buttonAlti = dizi[altindex][finalJ];
                                carp *= (Integer) buttonAlti.getData();
                                Notification.show("Çarpma" + carp);

                            }
                        }
                    });
                }
                else if (dizi[i][j] == dizi[3][0]) {

                    button.setIcon(FontAwesome.TIMES);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int yanindex = finalJ;
                            carp = 1;
                            for (int k = 1; k < 5; k++) {
                                yanindex += 1;
                                Button buttonAlti = dizi[finalI][yanindex];
                                carp *= (Integer) buttonAlti.getData();
                                Notification.show("Satır  Çarp" + carp);
                            }
                        }
                    });

                } else if (dizi[i][j] == dizi[0][4]) {

                    button.setIcon(FontAwesome.PERCENT);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int altindex = finalI;
                            bol=0;
                            toplam = 0;
                            for (int k = 1; k < 5; k++) {
                                altindex += 1;
                                Button buttonAlti = dizi[altindex][finalJ];
                                toplam += (Integer) buttonAlti.getData();
                            }
                            Button sonbutton = dizi[4][4];
                            double toplamsonuc = toplam;
                            double sondeger = Double.parseDouble(sonbutton.getData().toString());
                            double sonuc = (toplamsonuc / sondeger);
                            Notification.show("Bölme: " + sonuc);

                        }
                    });

                } else if (dizi[i][j] == dizi[4][0]) {

                    button.setIcon(FontAwesome.PERCENT);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            int yanindex = finalI;
                            bol=0;
                            toplam = 0;
                            for (int k = 1; k < 5; k++) {
                                yanindex += 1;
                                Button buttonAlti = dizi[finalI][yanindex];
                                toplam += (Integer) buttonAlti.getData();
                            }
                            Button sonbutton = dizi[4][4];
                            //  toplam=toplam/(Integer) sondeger.getData();
                            double toplamsonuc = toplam;
                            double sondeger = Double.parseDouble(sonbutton.getData().toString());
                            double sonuc = (toplamsonuc / sondeger);
                            Notification.show("Satır Bölme: " + sonuc);
                        }
                    });
                } else if (j > 0 && j < 5 && i > 0 && i < 5) {
                    valueBtn = getRandom();
                    dizi[i][j].setData(valueBtn);
                    dizi[i][j].setCaption(String.valueOf(valueBtn));
                }

                horizontalLayout.addComponent(button);
                horizontalLayout.setSpacing(true);
            }
            addComponent(horizontalLayout);
            setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);
            setSpacing(true);
            setMargin(true);
        }
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(21) - 10;
    }
}
