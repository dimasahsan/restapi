package com.dimas.restapi.domain.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase<T extends EntityBase<T>> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public boolean sameIdentityAs(final T that) {
		return this.equals(that);
	}
	
	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof EntityBase)) {
            return false;
        }
        final EntityBase<?> that = (EntityBase<?>) object;
        _checkIdentity(this);
        _checkIdentity(that);
        return this.id.equals(that.getId());
    }
	
	private void _checkIdentity(final EntityBase<?> entity) {
        if(entity.getId()==null){
            throw new IllegalStateException("Identity missing in entity: " + entity);
        }
    }
	
	@Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
