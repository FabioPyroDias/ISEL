using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana7_Teorica_CameraController : MonoBehaviour
{
    [SerializeField] private GameObject nearPosGameObject;
    [SerializeField] private float cameraSpeed;

    private SphereCollider sphereCollider;

    private Vector3 farPos;
    private Vector3 nearPos;

    private int numCollisions;
    private float pos;

    // Start is called before the first frame update
    void Start()
    {
        sphereCollider = GetComponent<SphereCollider>();

        farPos = transform.localPosition;
        nearPos = nearPosGameObject.transform.localPosition;

        pos = 0;
    }

    void Update() {
        if(numCollisions > 0)
        {
            pos += Time.deltaTime * cameraSpeed;
        }
        else
        {
            RaycastHit ignore;
            if(!Physics.SphereCast(transform.position, sphereCollider.radius, -transform.forward, out ignore, 1))
            {
                pos -= Time.deltaTime * cameraSpeed;
            }
        }

        pos = Mathf.Clamp01(pos);

        transform.localPosition = Vector3.Lerp(farPos, nearPos, pos);
    }

    private void OnTriggerEnter(Collider other)
    {
        numCollisions++;
    }

    private void OnTriggerExit(Collider other)
    {
        numCollisions--;
    }
}
