package com.pluralsight.interfaces;

import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.enums.ToppingTier;

public interface OrganizeToppings {
    ToppingCategory getCategory();
    ToppingTier getTier();
}
