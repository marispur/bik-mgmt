package com.mvproject.bik.designer.data;


public abstract class AbstractWorkComponent extends AbstractBikItem {

		
		/**
		 */
		public Float getDepreciation(){
			return new Float(0);
		}

			
			/**
			 */
			public Float getMaterials(){
				return new Float(0);
			}


				
				/**
				 */
				public Float getLabourNorm(){
					return new Float(0);
				}


					
					/**
					 */
					public Float getLabourPrice(){
						return new Float(0);
					}


						
						/**
						 */
						public Float getLabour(){
						 return new Float (this.getLabourNorm().floatValue() * this.getLabourPrice().floatValue());
						}

}
