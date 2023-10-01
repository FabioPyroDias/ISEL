using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Tank : MonoBehaviour
{
    public int speed;
    public float rotationSpeed;

    public GameObject bulletPrefab;
    public GameObject point;

    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Hello World");
    }

    void Update()
    {
        if(Input.GetButtonUp("Jump"))
        {
            Instantiate(bulletPrefab, point.transform.position, point.transform.rotation);
        }
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        float v = Input.GetAxisRaw("Vertical");
        
        Vector3 mov = new Vector3(0, 0, v) * Time.deltaTime * speed;
        
        transform.Translate(mov, Space.Self);

        float r = Input.GetAxisRaw("Horizontal");

        Vector3 rot = new Vector3(0, r, 0) * rotationSpeed;
        transform.Rotate(rot);
    }
}
