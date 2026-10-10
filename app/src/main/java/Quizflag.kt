package com.example.app1homework

import java.util.Random

class Quizflag(
    private val duration: Int,   // number of seconds each screen is displayed
    private val noFlags: Int     // total number of unique flags to display
) : Thread() {

    private var files = arrayOf(
        "afghanistan.bmp", "albania.bmp", "algeria.bmp", "american_samoa.bmp", "andorra.bmp", "angola.bmp", "anguilla.bmp",
        "antigua_and_barbuda.bmp", "argentina.bmp", "armenia.bmp", "aruba.bmp", "australia.bmp", "austria.bmp", "azerbaijan.bmp",
        "bahamas.bmp", "bahrain.bmp", "bangladesh.bmp", "barbados.bmp", "belarus.bmp", "belgium.bmp", "belize.bmp", "benin.bmp",
        "bermuda.bmp", "bhutan.bmp", "bolivia.bmp", "bosnia.bmp", "botswana.bmp", "brazil.bmp", "british_virgin_islands.bmp",
        "brunei.bmp", "bulgaria.bmp", "burkina_faso.bmp", "burundi.bmp", "cambodia.bmp", "cameroon.bmp", "canada.bmp", "cape_verde.bmp",
        "cayman_islands.bmp", "central_african_republic.bmp", "chad.bmp", "chile.bmp", "china.bmp", "christmas_island.bmp",
        "colombia.bmp", "comoros.bmp", "cook_islands.bmp", "costa_rica.bmp", "croatia.bmp", "cuba.bmp", "cyprus.bmp", "cyprus_northern.bmp",
        "czech_republic.bmp", "cte_divoire.bmp", "democratic_republic_of_the_congo.bmp", "denmark.bmp", "djibouti.bmp", "dominica.bmp",
        "dominican_republic.bmp", "ecuador.bmp", "egypt.bmp", "el_salvador.bmp", "equatorial_guinea.bmp", "eritrea.bmp", "estonia.bmp",
        "ethiopia.bmp", "falkland_islands.bmp", "faroe_islands.bmp", "fiji.bmp", "finland.bmp", "france.bmp", "french_polynesia.bmp",
        "gabon.bmp", "gambia.bmp", "georgia.bmp", "germany.bmp", "ghana.bmp", "gibraltar.bmp", "greece.bmp", "greenland.bmp", "grenada.bmp",
        "guam.bmp", "guatemala.bmp", "guinea.bmp", "guinea_bissau.bmp", "guyana.bmp", "haiti.bmp", "honduras.bmp", "hong_kong.bmp", "hungary.bmp",
        "iceland.bmp", "india.bmp", "indonesia.bmp", "iran.bmp", "iraq.bmp", "ireland.bmp", "israel.bmp", "italy.bmp", "jamaica.bmp", "japan.bmp",
        "jordan.bmp", "kazakhstan.bmp", "kenya.bmp", "kiribati.bmp", "kuwait.bmp", "kyrgyzstan.bmp", "laos.bmp", "latvia.bmp", "lebanon.bmp",
        "lesotho.bmp", "liberia.bmp", "libya.bmp", "liechtenstein.bmp", "lithuania.bmp", "luxembourg.bmp", "macao.bmp", "macedonia.bmp",
        "madagascar.bmp", "malawi.bmp", "malaysia.bmp", "maldives.bmp", "mali.bmp", "malta.bmp", "marshall_islands.bmp", "martinique.bmp",
        "mauritania.bmp", "mauritius.bmp", "mexico.bmp", "micronesia.bmp", "moldova.bmp", "monaco.bmp", "mongolia.bmp", "montserrat.bmp",
        "morocco.bmp", "mozambique.bmp", "myanmar.bmp", "namibia.bmp", "nauru.bmp", "nepal.bmp", "netherlands.bmp", "netherlands_antilles.bmp",
        "new_zealand.bmp", "nicaragua.bmp", "niger.bmp", "nigeria.bmp", "niue.bmp", "norfolk_island.bmp", "north_korea.bmp", "norway.bmp",
        "oman.bmp", "pakistan.bmp", "palau.bmp", "panama.bmp", "papua_new_guinea.bmp", "paraguay.bmp", "peru.bmp", "philippines.bmp",
        "pitcairn_islands.bmp", "poland.bmp", "portugal.bmp", "puerto_rico.bmp", "qatar.bmp", "republic_of_the_congo.bmp", "romania.bmp",
        "russian_federation.bmp", "rwanda.bmp", "saint_kitts_and_nevis.bmp", "saint_lucia.bmp", "saint_pierre.bmp", "saint_vicent_and_the_grenadines.bmp",
        "samoa.bmp", "san_marino.bmp", "sao_tom_and_prncipe.bmp", "saudi_arabia.bmp", "senegal.bmp", "serbia_and_montenegro.bmp",
        "seychelles.bmp", "sierra_leone.bmp", "singapore.bmp", "slovakia.bmp", "slovenia.bmp", "soloman_islands.bmp", "somalia.bmp",
        "south_africa.bmp", "south_georgia.bmp", "south_korea.bmp", "soviet_union.bmp", "spain.bmp", "sri_lanka.bmp", "sudan.bmp", "suriname.bmp",
        "swaziland.bmp", "sweden.bmp", "switzerland.bmp", "syria.bmp", "taiwan.bmp", "tajikistan.bmp", "tanzania.bmp", "thailand.bmp",
        "tibet.bmp", "timor_leste.bmp", "togo.bmp", "tonga.bmp", "trinidad_and_tobago.bmp", "tunisia.bmp", "turkey.bmp", "turkmenistan.bmp",
        "turks_and_caicos_islands.bmp", "tuvalu.bmp", "uae.bmp", "uganda.bmp", "ukraine.bmp", "united_kingdom.bmp", "united_states_of_america.bmp",
        "uruguay.bmp", "us_virgin_islands.bmp", "uzbekistan.bmp", "vanuatu.bmp", "vatican_city.bmp", "venezuela.bmp", "vietnam.bmp",
        "wallis_and_futuna.bmp", "yemen.bmp", "zambia.bmp", "zimbabwe.bmp"
    )


    private var countries = arrayOf(
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
        "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
        "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
        "Bermuda", "Bhutan", "Bolivia", "Bosnia", "Botswana", "Brazil", "British Virgin Islands",
        "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
        "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island",
        "Colombia", "Comoros", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Cyprus Northern",
        "Czech Republic", "Cte dIvoire", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica",
        "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
        "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Polynesia",
        "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada",
        "Guam", "Guatemala", "Guinea", "Guinea Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary",
        "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan",
        "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon",
        "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Macedonia",
        "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique",
        "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat",
        "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
        "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Norway",
        "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
        "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Republic of the Congo", "Romania",
        "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre", "Saint Vicent and the Grenadines",
        "Samoa", "San Marino", "Sao Tom and Prncipe", "Saudi Arabia", "Senegal", "Serbia and Montenegro",
        "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Soloman Islands", "Somalia",
        "South Africa", "South Georgia", "South Korea", "Soviet Union", "Spain", "Sri Lanka", "Sudan", "Suriname",
        "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
        "Tibet", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
        "Turks and Caicos Islands", "Tuvalu", "UAE", "Uganda", "Ukraine", "United Kingdom", "United States of America",
        "Uruguay", "US Virgin Islands", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
        "Wallis and Futuna", "Yemen", "Zambia", "Zimbabwe"
    )

    private var activity: MainActivity? = null

    fun attach(mainActivity: MainActivity) {
        activity = mainActivity
    }

    override fun run() {
        val random = Random()
        val chosenIndices = LinkedHashSet<Int>()
        while (chosenIndices.size < noFlags) {
            chosenIndices.add(random.nextInt(files.size))
        }
        val selected = chosenIndices.toList()

        try {
            while (!isInterrupted) {
                for (index in selected) {
                    val fileName = files[index]
                    val countryName = countries[index]
                    val host = activity ?: return

                    host.mainHandler.post(host.QuizHandler(fileName, "What Flag Is This?"))
                    sleep(duration * 1000L)

                    host.mainHandler.post(host.QuizHandler(fileName, countryName))
                    sleep(duration * 1000L)
                }
            }
        } catch (e: InterruptedException) {
        }
    }
}