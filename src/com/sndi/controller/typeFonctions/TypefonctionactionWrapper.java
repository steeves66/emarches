/*package com.sndi.controller.typeFonctions;

import com.sndi.model.TTypefonctionaction;

public class TypefonctionactionWrapper {

    private final TTypefonctionaction item;
    public TypefonctionactionWrapper(TTypefonctionaction item) {
        this.item = item;
    }

    public TTypefonctionaction getItem() {
        return item;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypefonctionactionWrapper && item.getSysAction().getSyaId() == ((TypefonctionactionWrapper) obj).item.getSysAction().getSyaId() ;
    }

    @Override
    public int hashCode() {
        return Long.valueOf( item.getSysAction().getSyaId() ).hashCode();
    }
	
}
*/