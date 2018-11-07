1. Mengapa perlu menginisiasi object PilotModel, sedangkan yang di test hanya FlightModel?

        karena data pada FlightModel yang ditest, memiliki kolom pilot yang berisi id dari pilot coki

2. Jelaskan apa yang akan terjadi jika object PilotModel dihapus dan tidak dilakukan setPilot pada FlightModel?

        maka test assertThat(found.get(), Matchers.equalTo(flightModel)) akan gagal

3. Jelaskan apa yang dilakukan oleh code
    Mockito.when(flightDb.findByFlightNumber(flight.get().getFlightNumber())).thenReturn(flight);

        mencoba untuk mengambil data flight pada database dengan parameter flightnumber yang diinginkan, jika ditemukan maka data tersebut akan dikembalikan

4. Jelaskan apa yang dilakukan oleh code
    Mockito.when(flightService.getFlightDetailByFlightNumber(flight.get().getFlightNumber())).thenReturn(flight);

        mencoba untuk mengambil data flight dari level service dengan parameter flightNumber, jika ditemukan maka data tersebut akan dikembalikan

5. Jelaskan apa yang ditest oleh code
    .andExpect(MockMvcResultMatchers.status().isOk())

        untuk mengetahui HttpStatus dari response halaman yang ditest,
        isOk() berarti HttpStatus = 200
        pada konteks ini artinya response mengandung data yang diminta dengan sesuai

6. Jelaskan apa yang ditest oleh code
        .andExpect(MockMvcResultMatchers.jsonPath("$.flightNumber", Matchers.is(flight.get().getFlightNumber())));

        jsonPath digunakan untuk mengakses response body dan mengambil spesifik subset dari response tersebut.
        dalam code diatas, kita menyocokan flightNumber pada response dengan flightNumber pada data test

7. Jelaskan anotasi @ResponseBody yang ada pada route "/flight/view"
        untuk mengembalikan response dalam bentuk Json



screenshoot: tutorial8-tets.png