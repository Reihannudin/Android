package dicoding.submission.reihannudin.pt1.rev.data

import dicoding.submission.reihannudin.pt1.rev.R
import dicoding.submission.reihannudin.pt1.rev.model.Food

object FoodData {

    private val productName = arrayOf(
        "Big Mac",
        "Double Cheseburger",
        "Hamburger",
        "McChicken",
        "Spicy Chicken",
        "Filled O'Fish",
        "Egg McMuffin",
        "Burrito",
        "McNuggets",
        "French Fries",
        "McFlurry Oreo",
        "Strawbery Smoothie",
        "Choco Shake",
        "Caramel Macchiato",
        "Coca Cola",
        "Vanila Cone"
//    total = 17
    )

    private val productImage = intArrayOf(
        R.drawable.big_mac_img,
        R.drawable.double_cheese_img,
        R.drawable.hamburger_img,
        R.drawable.mc_chicken_img,
        R.drawable.spicy_chicken_img,
        R.drawable.fillet_o_fish_img,
        R.drawable.egg_mc_muffin,
        R.drawable.burrito_img,
        R.drawable.chicken_nugget_img,
        R.drawable.french_fries_img,
        R.drawable.mcfurry_oreo_img ,
        R.drawable.strawberry_smothie_img,
        R.drawable.choco_shake_img,
        R.drawable.ice_caramel_machiato_img,
        R.drawable.coca_cola_img,
        R.drawable.vanila_cone_img
//    total = 17
    )

    private val productPrice = doubleArrayOf(
        3.50,
        2.80,
        1.90,
        1.95,
        2.50,
        2.00,
        2.00,
        2.15,
        1.50,
        1.50,
        2.20,
        2.50,
        2.50,
        2.70,
        0.50,
        0.80
//    total = 17
    )

    private val productStock = intArrayOf(
        10,
        10,
        10,
        10,
        10,
        10,
        10,
        10,
        10,
        10,
        10,
        0,
        10,
        10,
        10,
        10
//    total = 17
    )

    private val productDescription= arrayOf(
        "Big Mac is a hamburger with Mouthwatering perfection starts with two 100% pure beef patties and Big Mac® sauce sandwiched between a sesame seed bun and a large patty.",
        "The McDonald's Double Cheeseburger features two 100% pure beef burger patties seasoned with just a pinch of salt and pepper. It's topped with tangy pickles, chopped onions, ketchup, mustard and two slices of melty American cheese. ",
        "The original burger starts with a 100% pure beef burger seasoned with just a pinch of salt and pepper.",
        "McDonald's Crispy Chicken Sandwich is a southern style fried chicken sandwich that's crispy, juicy and tender perfection. It’s topped with crinkle-cut pickles and served on a toasted, buttered potato roll.",
        "With our Spicy Pepper Sauce topping the southern style fried chicken fillet on a toasted potato roll, this sandwich was made for those who like it crispy, juicy, tender and hot.",
        "Dive into our wild-caught Filet-O-Fish®! This McDonald’s fish sandwich has fish sourced from sustainably managed fisheries, on melty American cheese and topped with creamy McDonald’s tartar sauce, all served on a soft, steamed bun.",
        "Our Egg McMuffin® breakfast sandwich is an excellent source of protein and oh so delicious. We place a freshly cracked Grade A egg on a toasted English Muffin topped with real butter and add lean Canadian bacon and melty American cheese.",
        "The Sausage Burrito is McDonald's Breakfast Burrito and is loaded with fluffy scrambled egg, pork sausage, melty cheese, green chiles and onion! It's wrapped in a soft tortilla, making it the perfect grab and go breakfast.",
        "Our tender, juicy Chicken McNuggets® are made with all white meat chicken and no artificial colors, flavors or preservatives. ",
        "McDonald's World Famous Fries® are made with premium potatoes such as the Russet Burbank and the Shepody. With 0g of trans fat per labeled serving, these epic fries are crispy and golden on the outside and fluffy on the inside.",
        "The McDonald’s McFlurry® with OREO® Cookies is an popular combination of OREO® pieces and vanilla soft serve!",
        "McDonald's Strawberry Shake is made with creamy vanilla soft serve, blended with strawberry syrup and topped with whipped topping. ",
        "Try the McDonald’s Chocolate Shake, the perfect sweet treat for any time of the day. Our chocolate shake is made with delicious soft serve, chocolate syrup and finished off with a creamy whipped topping.",
        "The Iced Caramel Macchiato is made with our rich, dark-roasted roasted McCafe espresso and is served with whole milk, mixed with sweet caramel syrup. Then, it's topped off with buttery caramel drizzle.",
        "Coca-Cola® is a refreshing McDonald's soda option that complements all of your menu favorites.",
        "Enjoy our creamy vanilla soft serve in a crispy cone!"
    )
//
    private val productCategory = arrayOf(
        "Burgers",
        "Burgers",
        "Burgers",
        "Chicken",
        "Chicken",
        "Fish",
        "Breakfast",
        "Breakfast",
        "Snacks",
        "Snacks",
        "Snacks",
        "Dessert",
        "Dessert",
        "Dessert",
        "Drinks",
        "Dessert",
    )

    private val productAllergenInformation =  arrayOf(
        "Big Mac Bun\n" +
                "Ingredients: Enriched Flour (Wheat Flour, Malted Barley Flour, Niacin, Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Water, Sugar, Yeast, Soybean Oil, Contains 2% or Less: Salt, Wheat Gluten, Sesame Seeds, Potato Flour, May Contain One or More Dough Conditioners (DATEM, Ascorbic Acid, Mono and Diglycerides, Enzymes), Vinegar.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "100% Beef Patty\n" +
                "Ingredients: 100% Pure USDA Inspected Beef; No Fillers, No Extenders.\n" +
                "\n" +
                "Shredded Lettuce\n" +
                "Ingredients: Lettuce.\n" +
                "\n" +
                "Big Mac Sauce\n" +
                "Ingredients: Soybean Oil, Sweet Relish (Diced Pickles, Sugar, High Fructose Corn Syrup, Distilled Vinegar, Salt, Corn Syrup, Xanthan Gum, Calcium Chloride, Spice Extractives), Water, Egg Yolks, Distilled Vinegar, Spices, Onion Powder, Salt, Propylene Glycol Alginate, Garlic Powder, Vegetable Protein (Hydrolyzed Corn, Soy and Wheat), Sugar, Caramel Color, Turmeric, Extractives of Paprika, Soy Lecithin.\n" +
                "\n" +
                "Contains: Egg, Soy, Wheat.\n" +
                "Pasteurized Process American Cheese\n" +
                "Ingredients: Milk, Cream, Water, Sodium Citrate, Salt, Cheese Cultures, Citric Acid, Enzymes, Soy Lecithin, Color Added.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" +
                "Pickle Slices\n" +
                "Ingredients: Cucumbers, Water, Distilled Vinegar, Salt, Calcium Chloride, Alum, Potassium Sorbate (Preservative), Natural Flavors, Polysorbate 80, Extractives of Turmeric (Color).\n" +
                "\n" +
                "Onions\n" +
                "Ingredients: Onions.\n",
        "100% Beef Patty\n" +
                "Ingredients: 100% Pure USDA Inspected Beef; No Fillers, No Extenders.\n" +
                "\n" +
                "Regular Bun\n" +
                "Ingredients: Enriched Flour (Wheat Flour, Malted Barley Flour, Niacin, Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Water, Sugar, Yeast, Soybean Oil, Contains 2% or Less: Salt, Wheat Gluten, Potato Flour, May Contain One or More Dough Conditioners (DATEM, Ascorbic Acid, Mono and Diglycerides, Enzymes), Vinegar.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "Pasteurized Process American Cheese\n" +
                "Ingredients: Milk, Cream, Water, Sodium Citrate, Salt, Cheese Cultures, Citric Acid, Enzymes, Soy Lecithin, Color Added.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" +
                "Pickle Slices\n" +
                "Ingredients: Cucumbers, Water, Distilled Vinegar, Salt, Calcium Chloride, Alum, Potassium Sorbate (Preservative), Natural Flavors, Polysorbate 80, Extractives of Turmeric (Color).\n" +
                "\n" +
                "Ketchup\n" +
                "Ingredients: Tomato Concentrate from Red Ripe Tomatoes, Distilled Vinegar, High Fructose Corn Syrup, Corn Syrup, Water, Salt, Natural Flavors.\n" +
                "\n" +
                "Onions\n" +
                "Ingredients: Onions.\n" +
                "\n" +
                "Mustard\n" +
                "Ingredients: Distilled Vinegar, Water, Mustard Seed, Salt, Turmeric, Paprika, Spice Extractive.\n",
        "Regular Bun\n" +
                "Ingredients: Enriched Flour (Wheat Flour, Malted Barley Flour, Niacin, Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Water, Sugar, Yeast, Soybean Oil, Contains 2% or Less: Salt, Wheat Gluten, Potato Flour, May Contain One or More Dough Conditioners (DATEM, Ascorbic Acid, Mono and Diglycerides, Enzymes), Vinegar.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "100% Beef Patty\n" +
                "Ingredients: 100% Pure USDA Inspected Beef; No Fillers, No Extenders.\n" +
                "\n" +
                "Ketchup\n" +
                "Ingredients: Tomato Concentrate from Red Ripe Tomatoes, Distilled Vinegar, High Fructose Corn Syrup, Corn Syrup, Water, Salt, Natural Flavors.\n" +
                "\n" +
                "Pickle Slices\n" +
                "Ingredients: Cucumbers, Water, Distilled Vinegar, Salt, Calcium Chloride, Alum, Potassium Sorbate (Preservative), Natural Flavors, Polysorbate 80, Extractives of Turmeric (Color).\n" +
                "\n" +
                "Onions\n" +
                "Ingredients: Onions.\n" +
                "\n" +
                "Mustard\n" +
                "Ingredients: Distilled Vinegar, Water, Mustard Seed, Salt, Turmeric, Paprika, Spice Extractive.\n",
        "Crispy Chicken Fillet\n" +
                "Ingredients: Chicken Breast Fillets With Rib Meat, Water, Wheat Flour, Vegetable Oil (canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil), Sugar, Salt, Modified Food Starch, Leavening (baking Soda, Sodium Aluminum Phosphate, Sodium Acid Pyrophosphate, Monocalcium Phosphate), Yellow Corn Flour, Modified Corn Starch, Sodium Phosphate, Spices, Wheat Gluten, Yeast Extract, Monosodium Glutamate, Extractives Of Paprika (color), Natural Flavors, Gum Arabic, Maltodextrin.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "Potato Roll\n" +
                "Ingredients: Enriched Flour (wheat Flour, Malted Barley, Niacin, Reduced Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Flour (wheat Flour, Malted Barley Flour), Water, Sugar, Yeast, Potato Flour, Wheat Gluten, Soybean Oil, Contains 2% Or Less: Honey, Salt, Vinegar, Ascorbic Acid, Enzymes, Inactive Yeast, Datem, Natural Flavors, Vegetable Proteins (pea, Potato, Faba Bean), Vegetable Oil (canola And Or Sunflower Oil), Wheat Starch, Dextrose, Colors (turmeric, Paprika), Dextrose, Acetic Acid, Maltodextrin, Wheat Protein.\n" +
                "\n" +
                "Contains: Wheat\n" +
                "Crinkle Cut Pickle\n" +
                "Ingredients: Cucumbers, Water, Salt, Distilled Vinegar, Contains 2% Or Less: Calcium Chloride, Natural Flavors, Sodium Benzoate (preservative), Polysorbate 80, Turmeric (color).\n" +
                "\n" +
                "Salted Butter\n" +
                "Ingredients: Cream, Salt.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" ,
        "Crispy Chicken Fillet\n" +
                "Ingredients: Chicken Breast Fillets With Rib Meat, Water, Wheat Flour, Vegetable Oil (canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil), Sugar, Salt, Modified Food Starch, Leavening (baking Soda, Sodium Aluminum Phosphate, Sodium Acid Pyrophosphate, Monocalcium Phosphate), Yellow Corn Flour, Modified Corn Starch, Sodium Phosphate, Spices, Wheat Gluten, Yeast Extract, Monosodium Glutamate, Extractives Of Paprika (color), Natural Flavors, Gum Arabic, Maltodextrin.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "Potato Roll\n" +
                "Ingredients: Enriched Flour (wheat Flour, Malted Barley, Niacin, Reduced Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Flour (wheat Flour, Malted Barley Flour), Water, Sugar, Yeast, Potato Flour, Wheat Gluten, Soybean Oil, Contains 2% Or Less: Honey, Salt, Vinegar, Ascorbic Acid, Enzymes, Inactive Yeast, Datem, Natural Flavors, Vegetable Proteins (pea, Potato, Faba Bean), Vegetable Oil (canola And Or Sunflower Oil), Wheat Starch, Dextrose, Colors (turmeric, Paprika), Dextrose, Acetic Acid, Maltodextrin, Wheat Protein.\n" +
                "\n" +
                "Contains: Wheat\n" +
                "Spicy Pepper Sauce\n" +
                "Ingredients: Soybean Oil, Water, Distilled Vinegar, Egg Yolk, Habanero Pepper, Salt, Sugar, Contains 2% Or Less: Mustard Seed, Garlic, Onion, Xantham Gum, Red Bell Pepper, Lactic Acid, Propylene Glycol Alginate, Spice, Natural Flavor, Oleoresin Paprika (color), Preservatives (sodium Benzoate, Potassium Sorbate), Paprika, Turmeric, Calcium Disodium Edta (protect Flavor).\n" +
                "\n" +
                "Contains: Egg.\n" +
                "Crinkle Cut Pickle\n" +
                "Ingredients: Cucumbers, Water, Salt, Distilled Vinegar, Contains 2% Or Less: Calcium Chloride, Natural Flavors, Sodium Benzoate (preservative), Polysorbate 80, Turmeric (color).\n",
        "Fish Filet Patty\n" +
                "Ingredients: Pollock, Water, Vegetable Oil (Canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil), Wheat Flour, Modified Food Starch, Contains 2% or Less: Yellow Corn Flour, Bleached Wheat Flour, Salt, Whey (Milk), Dextrose, Dried Yeast, Sugar, Cellulose Gum, Paprika and Turmeric Extract (Color), Natural Flavors.\n" +
                "\n" +
                "Contains: Fish (Pollock), Wheat, Milk\n" +
                "Regular Bun\n" +
                "Ingredients: Enriched Flour (Wheat Flour, Malted Barley Flour, Niacin, Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Water, Sugar, Yeast, Soybean Oil, Contains 2% or Less: Salt, Wheat Gluten, Potato Flour, May Contain One or More Dough Conditioners (DATEM, Ascorbic Acid, Mono and Diglycerides, Enzymes), Vinegar.\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "Tartar Sauce\n" +
                "Ingredients: Soybean Oil, Pickle Relish (Diced Pickles, Vinegar, Salt, Capers, Xanthan Gum, Potassium Sorbate [Preservative], Calcium Chloride, Spice Extractives, Polysorbate 80), Egg Yolks, Water, Onions, Distilled Vinegar, Sugar, Spice, Salt, Xanthan Gum, Potassium Sorbate (Preservative), Parsley.\n" +
                "\n" +
                "Contains: Egg\n" +
                "Pasteurized Process American Cheese Half Slice\n" +
                "Ingredients: Milk, Cream, Water, Sodium Citrate, Salt, Cheese Cultures, Citric Acid, Enzymes, Soy Lecithin, Color Added.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" ,
        "English Muffin\n" +
                "Ingredients: Enriched Flour (Wheat Flour, Malted Barley Flour, Niacin, Iron, Thiamine, Riboflavin, Folic Acid), Water, Yeast, Yellow Corn Meal (Degermed Yellow Corn Meal and Corn Flour), Contains 2% or Less: Sugar, Soybean Oil, Salt, Dough Conditioners (Mono-, Di- and Tricalcium Phosphate, DATEM, Ascorbic Acid, Enzymes, Ethylated Mono and Digylcerides), Wheat Gluten, Cultured Wheat Flour, Citric Acid, Baking Soda, Fumaric Acid.\n" +
                "\n" +
                "Contains: Wheat\n" +
                "Egg\n" +
                "Ingredients: USDA Grade A Eggs.\n" +
                "\n" +
                "Contains: Egg\n" +
                "Canadian Bacon\n" +
                "Ingredients: Pork Cured With: Water, Sugar, Salt, Contains 2% or Less: Sodium Lactate, Sodium Phosphate, Natural Flavor, Maltodextrin, Sodium Diacetate and Sodium Nitrite (Preservatives).\n" +
                "\n" +
                "Pasteurized Process American Cheese\n" +
                "Ingredients: Milk, Cream, Water, Sodium Citrate, Salt, Cheese Cultures, Citric Acid, Enzymes, Soy Lecithin, Color Added.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" +
                "Salted Butter\n" +
                "Ingredients: Cream, Salt.\n" +
                "\n" +
                "Contains: Milk\n" +
                "Clarified Butter\n" +
                "Ingredients: Pasteurized Cream (Butterfat).\n" +
                "\n" +
                "Contains: Milk.\n" ,
        "Scrambled Egg Sausage And Vegetable Mix\n" +
                "Ingredients: Whole Eggs, Pork, Tomatoes, Skim Milk, Soybean Oil, Green Chilies, Onions, Modified Corn Starch, Spices, Salt, Water, Dextrose, Natural Flavors, Xanthan Gum, Citric Acid, Sugar, Rosemary Extract, Calcium Chloride, Citric Acid.\n" +
                "\n" +
                "Contains: Egg, Milk\n" +
                "Flour Tortilla\n" +
                "Ingredients: Enriched Flour (Bleached Wheat Flour, Malted Barley Flour, Niacin, Reduced Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Water, Shortening (Intereserified Soybean Oil, Soybean Oil, Hydrogenated Soybean Oil, Hydrogenated Cottonseed Oil), Contains 2% or Less: Sugar, Leavening (Baking Soda, Corn Starch, Sodium Aluminum Sulfate, Calcium Sulfate, Monocalcium Phosphate), Salt, Mono-diglycerides, Vital Wheat Gluten, Dough Conditioner (Sodium Metabisulfite, Corn Starch, Microcrystalline Cellulose, Dicalcium Phosphate).\n" +
                "\n" +
                "Contains: Wheat.\n" +
                "Pasteurized Process American Cheese\n" +
                "Ingredients: Milk, Cream, Water, Sodium Citrate, Salt, Cheese Cultures, Citric Acid, Enzymes, Soy Lecithin, Color Added.\n" +
                "\n" +
                "Contains: Milk, Soy.\n" ,
        "No Sauce\n" +
                "Chicken McNuggets®\n" +
                "Ingredients: White Boneless Chicken, Water, Vegetable Oil (canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil), Enriched Flour (bleached Wheat Flour, Niacin, Reduced Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Bleached Wheat Flour, Yellow Corn Flour, Vegetable Starch (modified Corn, Wheat, Rice, Pea, Corn), Salt, Leavening (baking Soda, Sodium Aluminum Phosphate, Sodium Acid Pyrophosphate, Calcium Lactate, Monocalcium Phosphate), Spices, Yeast Extract, Lemon Juice Solids, Dextrose, Natural Flavors.\n" +
                "\n" +
                "Contains: Wheat.\n" ,
        "French Fries\n" +
                "Ingredients: Potatoes, Vegetable Oil (canola Oil, Corn Oil, Soybean Oil, Hydrogenated Soybean Oil, Natural Beef Flavor [wheat And Milk Derivatives]*), Dextrose, Sodium Acid Pyrophosphate (maintain Color), Salt. *natural Beef Flavor Contains Hydrolyzed Wheat And Hydrolyzed Milk As Starting Ingredients.\n" +
                "\n" +
                "Contains: Wheat, Milk.\n" ,
        "Vanilla Reduced Fat Ice Cream\n" +
                "Ingredients: Milk, Sugar, Cream, Corn Syrup, Natural Flavor, Mono And Diglycerides, Cellulose Gum, Guar Gum, Carrageenan, Vitamin A Palmitate.\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Oreo Cookie Pieces\n" +
                "Ingredients: Unbleached Enriched Flour (wheat Flour, Niacin, Reduced Iron, Thiamine Mononitrate [vitamin B1], Riboflavin [vitamin B2], Folic Acid), Sugar, Palm And/or Canola Oil, Cocoa (processed With Alkali), Invert Sugar, Leavening (baking Soda And/or Calcium Phosphate), Soy Lecithin, Salt, Chocolate, Natural Flavor.\n" +
                "\n" +
                "Contains: Wheat, Soy.\n" ,
        "Vanilla Reduced Fat Ice Cream\n" +
                "Ingredients: Milk, Sugar, Cream, Corn Syrup, Natural Flavor, Mono and Diglycerides, Cellulose Gum, Guar Gum, Carrageenan, Vitamin A Palmitate.\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Strawberry Shake Syrup\n" +
                "Ingredients: Sugar, Strawberries, Corn Syrup, Glycerin, Strawberry Puree Concentrate, Water, Contains 2% Or Less: Natural Flavor, Vegetable Juice And Beta Carotene (color), Citric Acid, Pectin, Salt, Potassium Sorbate (preservative), Calcium Chloride.\n" +
                "\n" +
                "Whipped Light Cream\n" +
                "Ingredients: Cream, Nonfat Milk, Liquid Sugar, Contains 2% or Less: Mono and Diglycerides, Natural Flavors, Carrageenan. Whipping Propellant (Nitrous Oxide).\n" +
                "\n" +
                "Contains: Milk.\n" ,
        "Vanilla Reduced Fat Ice Cream\n" +
                "Ingredients: Milk, Sugar, Cream, Corn Syrup, Natural Flavor, Mono and Diglycerides, Cellulose Gum, Guar Gum, Carrageenan, Vitamin A Palmitate.\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Chocolate Shake Syrup\n" +
                "Ingredients: Sugar, Corn Syrup, Water, Glycerin, Cocoa (processed With Alkali), Fruit And Vegetable Juice (color), Salt, Natural Flavors, Potassium Sorbate (preservative).\n" +
                "\n" +
                "Whipped Light Cream\n" +
                "Ingredients: Cream, Nonfat Milk, Liquid Sugar, Contains 2% or Less: Mono and Diglycerides, Natural Flavors, Carrageenan. Whipping Propellant (Nitrous Oxide).\n" +
                "\n" +
                "Contains: Milk.\n" ,
        "Whole Milk\n" +
                "Ingredients: Milk, Vitamin D3 Added.\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Ice\n" +
                "Ingredients: Ice.\n" +
                "\n" +
                "Caramel Syrup\n" +
                "Ingredients: Sugar, Sweetened Condensed Skim Milk (Milk, Sugar), Water, Corn Syrup, Natural Flavors, Brown Sugar, Propylene Glycol, Sea Salt, Disodium Phosphate, Potassium Sorbate (Preservative).\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Water\n" +
                "Espresso\n" +
                "Ingredients: Espresso.\n" +
                "\n" +
                "Caramel Drizzle\n" +
                "Ingredients: Corn Syrup, Sweetened Condensed Milk (Milk, Sugar), Sugar, Water, Butter (Cream, Salt, Natural Flavor), Salt, Pectin, Disodium Phosphate, Natural Flavor, Caramel Color, Potassium Sorbate (Preservative).\n" +
                "\n" +
                "Contains: Milk.\n",
        "Coca-Cola\n" +
                "Ingredients: Carbonated Water, High Fructose Corn Syrup, Caramel Color, Natural Flavors, Caffeine.\n" +
                "\n" +
                "Ice\n" +
                "Ingredients: Ice.\n" ,
        "Vanilla Reduced Fat Ice Cream\n" +
                "Ingredients: Milk, Sugar, Cream, Corn Syrup, Natural Flavor, Mono And Diglycerides, Cellulose Gum, Guar Gum, Carrageenan, Vitamin A Palmitate.\n" +
                "\n" +
                "Contains: Milk.\n" +
                "Ice Cream Cone\n" +
                "Ingredients: Enriched Wheat Flour (wheat Flour, Niacin, Reduced Iron, Thiamine Mononitrate, Riboflavin, Folic Acid), Tapioca Starch, Sugar, Contains 2% Or Less: Canola Oil, Leavening (baking Soda, Ammonium Bicarbonate), Salt, Annatto Extract (color), Natural Flavor, Corn Syrup.\n" +
                "\n" +
                "Contains: Wheat.\n"
    )

    val listData : ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in productName.indices){

                val food = Food()
                food.nameProduct = productName[position]
                food.priceProduct = productPrice[position]
                food.imageProduct = productImage[position]
                food.stockProduct = productStock[position]
                food.categoryProduct = productCategory[position]
                food.descriptionProduct = productDescription[position]
                food.allergenInformation = productAllergenInformation[position]
                list.add(food)
            }
            return list
        }
}