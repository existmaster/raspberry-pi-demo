package com.kosta;

import com.pi4j.io.gpio.*;

public class App {
    public static void main(String[] args) {
        System.out.println("hello World");

        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput myLED = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "myLED", PinState.HIGH);
myLED.setMode(PinMode.DIGITAL_OUTPUT);
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }

            System.out.println("current state is " + myLED.getState());

            myLED.setState(PinState.HIGH);

            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }

            System.out.println("current state is " + myLED.getState());
            myLED.setState(PinState.LOW);

        }

        gpio.shutdown();
    }
}
