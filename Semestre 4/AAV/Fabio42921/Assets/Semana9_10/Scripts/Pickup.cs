using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Pickup : MonoBehaviour
{

    private PickupGenerator generator;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void SetGenerator(PickupGenerator generator)
    {
        this.generator = generator;
    }


    private void OnCollisionEnter(Collision collision)
    {
        Destroy(gameObject);
    }

    private void OnDestroy()
    {
        if(generator != null)
        {
            generator.CreateNewPickup();
        }
    }

}
